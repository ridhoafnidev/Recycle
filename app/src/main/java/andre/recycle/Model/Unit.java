package andre.recycle.Model;

import com.google.gson.annotations.SerializedName;

public class Unit {
    @SerializedName("unit_id")
    private String unit_id;
    @SerializedName("unit_nama")
    private String unit_nama;
    @SerializedName("unit_alamat")
    private String unit_alamat;
    @SerializedName("unit_kecamatan")
    private String unit_kecamatan;
    @SerializedName("unit_desa")
    private String unit_desa;
    @SerializedName("unit_pj")
    private String unit_pj;
    @SerializedName("unit_hp")
    private String unit_hp;
    @SerializedName("unit_email")
    private String unit_email;
    @SerializedName("unit_status_pendaftaran")
    private String unit_status_pendaftaran;
    @SerializedName("unit_foto1")
    private String unit_foto1;
    @SerializedName("unit_lat")
    private String unit_lat;
    @SerializedName("unit_lng")
    private String unit_lng;

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit_nama() {
        return unit_nama;
    }

    public void setUnit_nama(String unit_nama) {
        this.unit_nama = unit_nama;
    }

    public String getUnit_alamat() {
        return unit_alamat;
    }

    public void setUnit_alamat(String unit_alamat) {
        this.unit_alamat = unit_alamat;
    }

    public String getUnit_kecamatan() {
        return unit_kecamatan;
    }

    public void setUnit_kecamatan(String unit_kecamatan) {
        this.unit_kecamatan = unit_kecamatan;
    }

    public String getUnit_desa() {
        return unit_desa;
    }

    public void setUnit_desa(String unit_desa) {
        this.unit_desa = unit_desa;
    }

    public String getUnit_pj() {
        return unit_pj;
    }

    public void setUnit_pj(String unit_pj) {
        this.unit_pj = unit_pj;
    }

    public String getUnit_hp() {
        return unit_hp;
    }

    public void setUnit_hp(String unit_hp) {
        this.unit_hp = unit_hp;
    }

    public String getUnit_email() {
        return unit_email;
    }

    public void setUnit_email(String unit_email) {
        this.unit_email = unit_email;
    }

    public String getUnit_status_pendaftaran() {
        return unit_status_pendaftaran;
    }

    public void setUnit_status_pendaftaran(String unit_status_pendaftaran) {
        this.unit_status_pendaftaran = unit_status_pendaftaran;
    }

    public String getUnit_foto1() {
        return unit_foto1;
    }

    public void setUnit_foto1(String unit_foto1) {
        this.unit_foto1 = unit_foto1;
    }

    public String getUnit_lat() {
        return unit_lat;
    }

    public void setUnit_lat(String unit_lat) {
        this.unit_lat = unit_lat;
    }

    public String getUnit_lng() {
        return unit_lng;
    }

    public void setUnit_lng(String unit_lng) {
        this.unit_lng = unit_lng;
    }
}
