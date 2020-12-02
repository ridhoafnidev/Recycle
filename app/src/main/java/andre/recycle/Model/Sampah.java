package andre.recycle.Model;

import com.google.gson.annotations.SerializedName;

public class Sampah {
    @SerializedName("sampah_id")
    private String sampah_id;
    @SerializedName("sampah_nama")
    private String sampah_nama;
    @SerializedName("sampah_harga")
    private String sampah_harga;
    @SerializedName("sampah_foto")
    private String sampah_foto;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;

    public String getSampah_id() {
        return sampah_id;
    }

    public void setSampah_id(String sampah_id) {
        this.sampah_id = sampah_id;
    }

    public String getSampah_nama() {
        return sampah_nama;
    }

    public void setSampah_nama(String sampah_nama) {
        this.sampah_nama = sampah_nama;
    }

    public String getSampah_harga() {
        return sampah_harga;
    }

    public void setSampah_harga(String sampah_harga) {
        this.sampah_harga = sampah_harga;
    }

    public String getSampah_foto() {
        return sampah_foto;
    }

    public void setSampah_foto(String sampah_foto) {
        this.sampah_foto = sampah_foto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
