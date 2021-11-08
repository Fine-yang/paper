package com.example.demo.controller.vo;

import java.io.Serializable;

public class PollutionVO implements Serializable {
    private int id;
    private String region;
    private int year;
    private double CS_pw;
    private double CS_nw;
    private double CS_rc_Bio;
    private double CS_ps_Bio_SUM;
    private double CS_lf_mw_Bio;
    private double CS_ner_mw_Bio;
    private double CS_lf_iw;
    private double CS_ner_iw;
    private double AE_er_mw;
    private double AE_lf_mw_Bio;
    private double AE_er_iw;
    private double AE_WoodE;
    private double AE_lf_iw;
    private double CE_df;
    private double CE_wh;
    private double CE_nwh;
    private double CE_rpc;
    private double CE_chem_P;
    private double CE_wttrt_Pulp;
    private double CE_wttrt_Paper;
    private double CE_wttrt_ToNature_Pulp;
    private double CE_wttrt_ToNature_Paper;
    private double CE_prd_ExBio;
    private double CE_prd_Bio;
    private double CE_inc_Bio;
    private double CE_er_mw_Bio;
    private double CO2_lf_mw_Bio;
    private double CE_lf_mw_Bio;
    private double CECP_lf_mw_Bio;
    private double CESC_lf_mw_Bio;
    private double CE_er_iw;
    private double CE_WoodE;
    private double CO2_lf_iw;
    private double CE_lf_iw;
    private double CECP_lf_iw;
    private double CESC_lf_iw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCS_pw() {
        return CS_pw;
    }

    public void setCS_pw(double CS_pw) {
        this.CS_pw = CS_pw;
    }

    public double getCS_nw() {
        return CS_nw;
    }

    public void setCS_nw(double CS_nw) {
        this.CS_nw = CS_nw;
    }

    public double getCS_rc_Bio() {
        return CS_rc_Bio;
    }

    public void setCS_rc_Bio(double CS_rc_Bio) {
        this.CS_rc_Bio = CS_rc_Bio;
    }

    public double getCS_ps_Bio_SUM() {
        return CS_ps_Bio_SUM;
    }

    public void setCS_ps_Bio_SUM(double CS_ps_Bio_SUM) {
        this.CS_ps_Bio_SUM = CS_ps_Bio_SUM;
    }

    public double getCS_lf_mw_Bio() {
        return CS_lf_mw_Bio;
    }

    public void setCS_lf_mw_Bio(double CS_lf_mw_Bio) {
        this.CS_lf_mw_Bio = CS_lf_mw_Bio;
    }

    public double getCS_ner_mw_Bio() {
        return CS_ner_mw_Bio;
    }

    public void setCS_ner_mw_Bio(double CS_ner_mw_Bio) {
        this.CS_ner_mw_Bio = CS_ner_mw_Bio;
    }

    public double getCS_lf_iw() {
        return CS_lf_iw;
    }

    public void setCS_lf_iw(double CS_lf_iw) {
        this.CS_lf_iw = CS_lf_iw;
    }

    public double getCS_ner_iw() {
        return CS_ner_iw;
    }

    public void setCS_ner_iw(double CS_ner_iw) {
        this.CS_ner_iw = CS_ner_iw;
    }

    public double getAE_er_mw() {
        return AE_er_mw;
    }

    public void setAE_er_mw(double AE_er_mw) {
        this.AE_er_mw = AE_er_mw;
    }

    public double getAE_lf_mw_Bio() {
        return AE_lf_mw_Bio;
    }

    public void setAE_lf_mw_Bio(double AE_lf_mw_Bio) {
        this.AE_lf_mw_Bio = AE_lf_mw_Bio;
    }

    public double getAE_er_iw() {
        return AE_er_iw;
    }

    public void setAE_er_iw(double AE_er_iw) {
        this.AE_er_iw = AE_er_iw;
    }

    public double getAE_WoodE() {
        return AE_WoodE;
    }

    public void setAE_WoodE(double AE_WoodE) {
        this.AE_WoodE = AE_WoodE;
    }

    public double getAE_lf_iw() {
        return AE_lf_iw;
    }

    public void setAE_lf_iw(double AE_lf_iw) {
        this.AE_lf_iw = AE_lf_iw;
    }

    public double getCE_df() {
        return CE_df;
    }

    public void setCE_df(double CE_df) {
        this.CE_df = CE_df;
    }

    public double getCE_wh() {
        return CE_wh;
    }

    public void setCE_wh(double CE_wh) {
        this.CE_wh = CE_wh;
    }

    public double getCE_nwh() {
        return CE_nwh;
    }

    public void setCE_nwh(double CE_nwh) {
        this.CE_nwh = CE_nwh;
    }

    public double getCE_rpc() {
        return CE_rpc;
    }

    public void setCE_rpc(double CE_rpc) {
        this.CE_rpc = CE_rpc;
    }

    public double getCE_chem_P() {
        return CE_chem_P;
    }

    public void setCE_chem_P(double CE_chem_P) {
        this.CE_chem_P = CE_chem_P;
    }

    public double getCE_wttrt_Pulp() {
        return CE_wttrt_Pulp;
    }

    public void setCE_wttrt_Pulp(double CE_wttrt_Pulp) {
        this.CE_wttrt_Pulp = CE_wttrt_Pulp;
    }

    public double getCE_wttrt_Paper() {
        return CE_wttrt_Paper;
    }

    public void setCE_wttrt_Paper(double CE_wttrt_Paper) {
        this.CE_wttrt_Paper = CE_wttrt_Paper;
    }

    public double getCE_wttrt_ToNature_Pulp() {
        return CE_wttrt_ToNature_Pulp;
    }

    public void setCE_wttrt_ToNature_Pulp(double CE_wttrt_ToNature_Pulp) {
        this.CE_wttrt_ToNature_Pulp = CE_wttrt_ToNature_Pulp;
    }

    public double getCE_wttrt_ToNature_Paper() {
        return CE_wttrt_ToNature_Paper;
    }

    public void setCE_wttrt_ToNature_Paper(double CE_wttrt_ToNature_Paper) {
        this.CE_wttrt_ToNature_Paper = CE_wttrt_ToNature_Paper;
    }

    public double getCE_prd_ExBio() {
        return CE_prd_ExBio;
    }

    public void setCE_prd_ExBio(double CE_prd_ExBio) {
        this.CE_prd_ExBio = CE_prd_ExBio;
    }

    public double getCE_prd_Bio() {
        return CE_prd_Bio;
    }

    public void setCE_prd_Bio(double CE_prd_Bio) {
        this.CE_prd_Bio = CE_prd_Bio;
    }

    public double getCE_inc_Bio() {
        return CE_inc_Bio;
    }

    public void setCE_inc_Bio(double CE_inc_Bio) {
        this.CE_inc_Bio = CE_inc_Bio;
    }

    public double getCE_er_mw_Bio() {
        return CE_er_mw_Bio;
    }

    public void setCE_er_mw_Bio(double CE_er_mw_Bio) {
        this.CE_er_mw_Bio = CE_er_mw_Bio;
    }

    public double getCO2_lf_mw_Bio() {
        return CO2_lf_mw_Bio;
    }

    public void setCO2_lf_mw_Bio(double CO2_lf_mw_Bio) {
        this.CO2_lf_mw_Bio = CO2_lf_mw_Bio;
    }

    public double getCE_lf_mw_Bio() {
        return CE_lf_mw_Bio;
    }

    public void setCE_lf_mw_Bio(double CE_lf_mw_Bio) {
        this.CE_lf_mw_Bio = CE_lf_mw_Bio;
    }

    public double getCECP_lf_mw_Bio() {
        return CECP_lf_mw_Bio;
    }

    public void setCECP_lf_mw_Bio(double CECP_lf_mw_Bio) {
        this.CECP_lf_mw_Bio = CECP_lf_mw_Bio;
    }

    public double getCESC_lf_mw_Bio() {
        return CESC_lf_mw_Bio;
    }

    public void setCESC_lf_mw_Bio(double CESC_lf_mw_Bio) {
        this.CESC_lf_mw_Bio = CESC_lf_mw_Bio;
    }

    public double getCE_er_iw() {
        return CE_er_iw;
    }

    public void setCE_er_iw(double CE_er_iw) {
        this.CE_er_iw = CE_er_iw;
    }

    public double getCE_WoodE() {
        return CE_WoodE;
    }

    public void setCE_WoodE(double CE_WoodE) {
        this.CE_WoodE = CE_WoodE;
    }

    public double getCO2_lf_iw() {
        return CO2_lf_iw;
    }

    public void setCO2_lf_iw(double CO2_lf_iw) {
        this.CO2_lf_iw = CO2_lf_iw;
    }

    public double getCE_lf_iw() {
        return CE_lf_iw;
    }

    public void setCE_lf_iw(double CE_lf_iw) {
        this.CE_lf_iw = CE_lf_iw;
    }

    public double getCECP_lf_iw() {
        return CECP_lf_iw;
    }

    public void setCECP_lf_iw(double CECP_lf_iw) {
        this.CECP_lf_iw = CECP_lf_iw;
    }

    public double getCESC_lf_iw() {
        return CESC_lf_iw;
    }

    public void setCESC_lf_iw(double CESC_lf_iw) {
        this.CESC_lf_iw = CESC_lf_iw;
    }
}
