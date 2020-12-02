package andre.recycle.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUnit {
    @SerializedName("kode")
    private Integer kode;
    @SerializedName("hasil")
    private List<Unit> unit = null;

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public List<Unit> getUnit() {
        return unit;
    }

    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }
}
