package crystal;

import arc.files.*;
import arc.assets.*;
import com.google.firebase.FirebaseOptions;

public class Vars implements Loadable{
    /** crystal edition main data directory **/
    public static Fi mainDirectory;
    /** Crystal edition content **/
    public static Boolean originalActivate = true;
    /** Debug mode. **/
    public static Boolean debugMode = false;
    /** Internet connection **/
    public static Boolean onlineMode = true;
    /** Firebase setups **/
    public static FirebaseOptions firebaseOptions;
}