package crystal.io;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.*;

import arc.util.*;

import static crystal.Vars.*;

public class DatabaseSetup {
    private FirebaseOptions dbConfig;

    public DatabaseSetup(){}

    public void init(){
        try {
            dbConfig = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(getClass().getResourceAsStream("/fbcfssdkkey.json")))
                    .setProjectId("gamerstudio") // 프로젝트 id
                    .setDatabaseUrl("https://gamerstudio.firebaseio.com") // 실시간 데이터베이스 주소
                    .setStorageBucket("gamerstudio.appspot.com") // 스토리지 주소
                    .build();
        } catch (IOException e) {
            Log.info(e);
        }
        FirebaseApp.initializeApp(dbConfig);

        firebaseDBFirestore = FirestoreClient.getFirestore();
    }
}
