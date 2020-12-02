package andre.recycle.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUser {
    @SerializedName("kode")
    private Integer kode;
    @SerializedName("hasil")
    private User hasil;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public User getHasil() {
        return hasil;
    }

    public void setHasil(User hasil) {
        this.hasil = hasil;
    }
}
