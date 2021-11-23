$(document).ready(function () {
    var myColumns = new Array()
    var years = new Array()
    $(function () {

        //1.初始化Table
        var oTable = new TableInit();


        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    })

    function getColumns() {
        // 加载动态表格
        $.ajax({
            url: '/getAll',
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                myColumns.push({
                    fileid: 'state', checkbox: true, formatter: function (value, row, index) {   //加复选框
                        console.info(value);
                        return value;
                    }
                })
                console.log(myColumns)
                // 异步获取要动态生成的列
                var arr = Object.keys(returnValue[0]) ;
                $.each(arr, function(i, item) {
                    if (item =='id'){
                        console.log("id")
                    }else if (i<4){
                        console.log(item)
                        myColumns.push({
                            "field" : item,
                            "title" : item,
                            "visible": true,
                            "sortable": true
                        });
                    }else {
                        console.log(item)
                        myColumns.push({
                            "field" : item,
                            "title" : item,
                            "visible": false,
                            "sortable": true
                        });}
                });
                $('#table').bootstrapTable(
                    'refreshOptions',
                    {
                        url : "/getAll", // 获取数据的地址
                        columns : myColumns,

                    }
                )
                printChart();
                return myColumns;
            }
        });

    }

    function getRegions(){
        $.ajax({
            // url : '/initTable',
            url: '/getRegion',
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                var arr = returnValue ;
                $.each(arr, function(i, item) {
                    var option = "<option>"+item+"</option>"
                    // console.log(option)
                    $("#region-select").append(option)
                });
            }
        });
    }

    function getYears(){
        $.ajax({
            // url : '/initTable',
            url: '/getYear',
            type : 'get',
            dataType : "json",
            async : true,
            success : function(returnValue) {
                var arr = returnValue ;

                $.each(arr, function(i, item) {
                    var option = "<option>"+item+"</option>"
                    // console.log(option)
                    years.push(item)
                    $("#year-select").append(option)
                });
            }
        });
    }

    function printChart(){
        // console.log("322233333333333333333333333333333333")
        // var $table = $("#table")
        var data = $table.bootstrapTable('getData')
        var cols= $table.bootstrapTable('getVisibleColumns');
        var colList = new Array();
        for (var i=0; i<cols.length; i++){
            var title = cols[i]['title'];
            // console.log(title);
            if(title== 'region' || title=="year"){
                continue;
            }
            colList.push(title);
            // resStr += `${title},`
        }
        var years = new Array()
        var colData = {}

        for(var i = 0; i<data.length;i++){
            years.push(data[i]['year']);
        }
        for (var j =0; j < colList.length; j++){
            colData[colList[j]] = new Array();
        }
        for(var i = 0; i<data.length;i++) {
            for (var j = 0; j < colList.length; j++) {
                colData[colList[j]].push(data[i][colList[j]]);
            }
        }
        var seriesArray = new Array()
        for (var j =0; j < colList.length; j++){
            seriesArray.push({
                name: colList[j],
                type: 'line',
                stack: 'Total',
                data: colData[colList[j]]
            })
        }
        var chartDom = document.getElementById('chart');
        var myChart = echarts.init(chartDom);
        var option;
        option = {
            title: {
                text: 'Trends'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: colList
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: years
            },
            yAxis: {
                type: 'value'
            },
            series:seriesArray
        };
        option && myChart.setOption(option,true);
    }

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#table').bootstrapTable({
                // url: '/initTable',            //请求后台的URL（*）
                url: "/getAll",
                method: 'get',            //请求方式（*）
                contentType: "application/x-www-form-urlencoded",

                toolbar: '#toolbar',        //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                showPaginationSwitch: true,
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 50,                       //每页的记录行数（*）
                pageList: [10, 15, 20, 30,50, 100],        //可供选择的每页的行数（*）
                // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                // showColumnsToggleAll: true,
                // showExport: true,
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                // height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                        //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns:  myColumns,
                onLoadSuccess:function (){
                    printChart()
                },
                onColumnSwitch: function (){
                   printChart()
                }
            })


        };
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                //limit: params.limit,   //页面大小
                //offset: params.offset,  //
                // region: null,
                region: $('#region-select  option:selected').val(),
                // year: null,
                year: $('#year-select option:selected').val(),
                // search: params.search       //加了这个，就可以使用自带的搜索功能了
            };
            return temp;
        };
        return oTableInit;
    };

    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };

    $('#table').on('click-row.bs.table', function (e, row, $element) {
        $('.success').removeClass('success');
        $($element).addClass('success');
    });

    var $table = $('#table');
    getColumns();
    getRegions();
    getYears();


    //初始化button的点击事件
    $(function() {
        // $("#chang-bg").click(function (){
        //     console.log("1111111")
        //     $("#bg-img").css("background-image","linear-gradient(to top,rgba(255,255,255,1) 10%, rgba(255,255,255,0.8) 30%, rgba(255,255,255,0.6) 45%, rgba(255,255,255,0.2) 60%, rgba(255,255,255,0) 90%,rgba(0,0,0,0.4) 6%), url(\"/imgs/bg2.jpg\")")
        // })

        $("#search-button").click(function () {
            $table.bootstrapTable(
                "refreshOptions",
                {
                    url : "/getAll", // 获取数据的地址
                    columns : myColumns,


                }
            );

        })

        $('#output').click(function (){
            $("#myModal").modal();

        })
        $("#btn_save").click(function (){
            var result = $table.bootstrapTable('getSelections');
            var cols= $table.bootstrapTable('getVisibleColumns');
            var colList = new Array();
            let resStr = ``;
            for (var i=0; i<cols.length; i++){
                var title = cols[i]['title'];
                console.log(title);
                colList.push(title);
                resStr += `${title},`
            }
            resStr+='\n';
            console.log(colList);
            var resultData = new Array();
            for(var i = 0; i<result.length;i++){
                var tmp = {};
                for (var j =0; j < colList.length; j++){
                    tmp[colList[j]] = result[i][colList[j]];
                }
                resultData.push(tmp);
            }

            for(let i = 0 ; i < resultData.length ; i++ ){
                for(let item in resultData[i]){
                    resStr+=`${resultData[i][item] + '\t'},`;
                }
                resStr+='\n';
            }
            let uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(resStr);
            let link = document.createElement("a");
            link.href = uri;

            var fileName = $("#savefilename").val();
            console.log(fileName)
            // var fileName = prompt("请输入要保存的文件名： ","造纸数据库")
            link.download =  fileName + ".csv";
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);
            })
    })


});

