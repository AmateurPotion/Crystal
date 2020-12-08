package crystal;

import arc.files.*;
import arc.assets.*;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseOptions;

public class Vars implements Loadable{
    /** crystal edition main data directory **/
    public static Fi mainDirectory;
    /** Crystal edition content **/
    public static Boolean originalActivate = true;
    /** Mod server connection **/
    public static Boolean mainServerConnected;
    /** Debug mode. **/
    public static Boolean debugMode = false;
    /** Firebase config **/
    public static Firestore firebaseDBFirestore;
}