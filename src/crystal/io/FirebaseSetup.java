package crystal.io;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;

import arc.util.Log;

import static crystal.Vars.*;

public class FirebaseSetup {
    private FirebaseOptions options;

    public void init(){
        /* TODO: 이거 사용 방법을 찾아야됨 - 클라이언트 라이브러리 사용방법이라고 문서에 나와있긴한데 뭐라카는 건지는 모르긋다..
            https://cloud.google.com/storage/docs/reference/libraries?authuser=0#windows
        import com.google.cloud.storage.*;

        method args -> (String...args)

        Storage storage = StorageOptions.getDefaultInstance().getService();
        String bucketName = args[0];
        Bucket bucket = storage.create(BucketInfo.of(bucketName));
         */

        try {
            InputStream clientToken = getClass().getResourceAsStream("/GamerStudio-ca6e9e9bdf74.json");

            options = FirebaseOptions.builder()
                    .setProjectId("gamerstudio")
                    .setDatabaseUrl("https://gamerstudio.firebaseio.com")
                    .setCredentials(GoogleCredentials.fromStream(clientToken))
                    .setStorageBucket("gamerstudio.appspot.com")
                    .build();
        } catch (IOException e) {
            Log.info(e);
        }
        firebaseOptions = options;
    }
}
