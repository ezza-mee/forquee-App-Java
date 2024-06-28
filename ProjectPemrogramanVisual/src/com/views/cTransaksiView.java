package com.views;

import com.templates.cFrameTransaksiApp;

import com.partials.*;

public class cTransaksiView extends cFrameTransaksiApp {

    private cTextPembayaran txtJumlahMakananTransaksi = new cTextPembayaran(40, 40, 40, 40, false);

    private cLabelInfo labelCoba = new cLabelInfo("HEllo", 100, 100, 100 ,100);
    
    public void cTransaksiView() {

        cardPembayaran.add(txtJumlahMakananTransaksi);
        cardPembayaran.add(labelCoba);

        setVisible(true);
    }
}
