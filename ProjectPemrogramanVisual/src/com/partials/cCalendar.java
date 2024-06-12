package com.partials;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class cCalendar extends JPanel {
    private LocalDate currentDate;
    private JLabel labelDate;

    public cCalendar(int x, int y) {
        super();
        this.setBounds(x, y, 200, 30);
        this.setOpaque(true);
        this.setBackground(cColor.GREEN);

        // Menginisialisasi tanggal saat ini
        currentDate = LocalDate.now();

        // Mengatur tampilan label untuk menampilkan tanggal
        labelDate = new JLabel();
        updateDateLabel();
        this.add(labelDate);
        labelDate.setFont(cFonts.LABEL_TANGGAL_FONT);
        labelDate.setForeground(cColor.WHITE);
    }

    // Metode untuk memperbarui label dengan tanggal saat ini
    private void updateDateLabel() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedDate = currentDate.format(formatter);
        labelDate.setText(formattedDate);
    }

    // Metode untuk memperbarui tanggal ke tanggal yang diberikan
    public void setDate(LocalDate date) {
        currentDate = date;
        updateDateLabel();
    }

    // Metode untuk mendapatkan tanggal saat ini
    public LocalDate getDate() {
        return currentDate;
    }
}
