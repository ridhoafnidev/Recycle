package andre.recycle.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import andre.recycle.Activity.LoginActivity;

public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static final String KEY_PENGGUNA_ID = "id";
    public static final String KEY_PENGGUNA_NAMA = "name";
    public static final String KEY_PENGGUNA_EMAIL = "email";
    public static final String KEY_PENGGUNA_LEVEL = "level";
    public static final String KEY_PENGGUNA_HAK_AKSES = "akses_id";
    public static final String KEY_PENGGUNA_NOMOR = "nomor";
    public static final String KEY_PENGGUNA_VALIDASI = "email_verified_at";
    public static final String LOGGIN_STATUS = "sudahlogin";
    public static final String SHARE_NAME = "logginsession";
    private Context context;
    private final int MODE_PRIVATE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLogin(String id,
                          String email,
                          String nama,
                          String level,
                          String akses,
                          String nomor) {
        editor.putBoolean(LOGGIN_STATUS, true);
        editor.putString(KEY_PENGGUNA_ID, id);
        editor.putString(KEY_PENGGUNA_EMAIL, email);
        editor.putString(KEY_PENGGUNA_NAMA, nama);
        editor.putString(KEY_PENGGUNA_LEVEL, level);
        editor.putString(KEY_PENGGUNA_HAK_AKSES, akses);
        editor.putString(KEY_PENGGUNA_NOMOR, nomor);
        editor.commit();
    }
    public void saveValidasi(String validasi){
        editor.putString(KEY_PENGGUNA_VALIDASI,validasi);
        editor.commit();
    }

    public HashMap getDetailsLoggin() {
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_PENGGUNA_NAMA, sharedPreferences.getString(KEY_PENGGUNA_NAMA, null));
        map.put(KEY_PENGGUNA_ID, sharedPreferences.getString(KEY_PENGGUNA_ID, null));
        map.put(KEY_PENGGUNA_HAK_AKSES, sharedPreferences.getString(KEY_PENGGUNA_HAK_AKSES, null));
        map.put(KEY_PENGGUNA_EMAIL, sharedPreferences.getString(KEY_PENGGUNA_EMAIL, null));
        map.put(KEY_PENGGUNA_LEVEL, sharedPreferences.getString(KEY_PENGGUNA_LEVEL, null));
        map.put(KEY_PENGGUNA_NOMOR, sharedPreferences.getString(KEY_PENGGUNA_NOMOR, null));
        map.put(KEY_PENGGUNA_VALIDASI, sharedPreferences.getString(KEY_PENGGUNA_VALIDASI, null));
        return map;
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent i = new Intent(context, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    public Boolean isLogin() {
        return sharedPreferences.getBoolean(LOGGIN_STATUS, false);
    }
}
