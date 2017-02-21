package com.example.sipo.rumusbidangdatar;

/**
 * Created by SIPO on 4/24/2016.
 */
public class Bangun {
    private  String namaBangun;
    private  int gmbrBangun;

    public Bangun(String namaBangun, int gmbrBangun) {
        this.namaBangun = namaBangun;
        this.gmbrBangun = gmbrBangun;
    }

    public String getNamaBangun() {
        return namaBangun;
    }

    public void setNamaBangun(String namaBangun) {
        this.namaBangun = namaBangun;
    }

    public int getGmbrBangun() {
        return gmbrBangun;
    }

    public void setGmbrBangun(int gmbrBangun) {
        this.gmbrBangun = gmbrBangun;
    }
}
