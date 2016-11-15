## ajds (Android JSON document store)
Small helper classes to store JSON Objects/array into the [mode.private](https://developer.android.com/guide/topics/data/data-storage.html#filesInternal) storage on Android's internal storage. By default, files saved to the internal storage are private to your application and other applications cannot access them (nor can the user).


###Usage

    final aArray db = new aArray(getApplicationContext(), "your_doc_name");


### Check if doc exits

    boolean exits = db.checkUserFile();
    
### Write/create new 

    db.writeUserFile(JSONArray);    
    
### Read

     JSONArray MyArray = db.readUserFile();    
    

