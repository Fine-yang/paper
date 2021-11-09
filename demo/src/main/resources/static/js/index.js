$(document).ready(function () {
    // $('#example').DataTable();
    //
    // var table = $('#population_table ').DataTable( {
    //     "columnDefs": [
    //         {
    //             "searchable": false,
    //             "orderable": false,
    //             "targets": 0
    //         },
    //         {
    //             "targets": [ 2 ],
    //             "visible": false,
    //             "searchable": false
    //         },
    //         {
    //             "targets": [ 3 ],
    //             "visible": false
    //         }
    //
    //     ],
    //     "order": [[ 1, 'asc' ]],
    //     "scrollX": true,
    //     buttons: [
    //         'copy', 'excel', 'pdf'
    //     ]
    // } );
    // table.on( 'order.dt search.dt', function () {
    //     table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
    //         cell.innerHTML = i+1;
    //     } );
    // } ).draw();
    $(function () {

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    })

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#table').bootstrapTable({
                // url: '/SelectCourse/GetCourseTable',            //请求后台的URL（*）
                method: 'get',            //请求方式（*）
                toolbar: '#toolbar',        //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                // showPaginationSwitch: true,
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 100,                       //每页的记录行数（*）
                pageList: [5, 25, 50, 100],        //可供选择的每页的行数（*）
                // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                // showColumnsToggleAll: true,
                // showExport: true,
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 800,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                        //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                // icons:{
                //     export: {
                //         bootstrap3: 'glyphicon-plus icon-share',
                //         materialize: 'file_download',
                //         'bootstrap-table': 'icon-download'
                //     }
                // },
                columns: [{
                    fileid: 'state', checkbox: true, formatter: function (value, row, index) {   //加复选框
                        // if (index === 2) {
                        //    return {
                        //        // disabled: true,
                        //        checked: true
                        //    }
                        // }
                        console.info(value);
                        return value;
                    }
                },
                    {
                        field: 'Name',
                        title: 'Name',
                        visible: true
                }, {
                    field: 'Position',
                    title: 'Position',
                        visible: true


                    }, {
                    field: 'Office',
                    title: 'Office'

                    }, {
                    field: 'Age',
                    title: 'Age'

                    }, {
                    field: 'Start_date',
                    title: 'Start_date'
                    }, {
                        field: 'Salary',
                        title: 'Salary'
                    }
                ]
            });
        };
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                //limit: params.limit,   //页面大小
                //offset: params.offset,  //页码
                departmentname: $("#txt_search_Coursename").val(),
                statu: $("#txt_search_Teacher").val(),
                search: params.search       //加了这个，就可以使用自带的搜索功能了
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

    var $table = $('#table'),   //可写可不写
        $button = $('#btn');





    $button.click(function () {      //因为这个，你可以编辑表格了！
        var result = $table.bootstrapTable('getSelections');
        alert('getSelections: ' + JSON.stringify($table.bootstrapTable('getSelections')));
        var ids = [];
        for (var i = 0; i < result.length; i++) {

            var item = result[i];
            //ids.push(item.授课老师);
        }
        alert(ids);
    })

});

