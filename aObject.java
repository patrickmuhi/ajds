package ceddy.ajds;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by Ceddy Muhoza
 */
public class aObject {

    Context context;
    String USER_FILE;

    public aObject(Context context, String u){
        this.context = context;
        this.USER_FILE = u;
    }

    public void writeUserFile(JSONObject me){
        if(checkUserFile())
            deleteUserFile();
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(USER_FILE, Context.MODE_PRIVATE);
            outputStream.write(me.toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject readUserFile(){
        File dir = context.getFilesDir();
        File file = new File(dir, USER_FILE);
        StringBuilder text = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            return new JSONObject(text.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteUserFile(){
        File dir = context.getFilesDir();
        File file = new File(dir, USER_FILE);
        file.delete();
    }

    public boolean checkUserFile(){
        File dir = context.getFilesDir();
        File file = new File(dir, USER_FILE);
        return file.exists();
    }
}
