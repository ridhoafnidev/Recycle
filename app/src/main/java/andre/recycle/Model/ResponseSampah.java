package andre.recycle.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSampah {
    @SerializedName("kode")
    private Integer kode;
    @SerializedName("hasil")
    private List<Sampah> sampah = null;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getKode() {
        return kode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public List<Sampah> getSampah() {
        return sampah;
    }

    public void setSampah(List<Sampah> sampah) {
        this.sampah = sampah;
    }
}
