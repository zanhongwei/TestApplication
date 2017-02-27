package contant.zhw.zxzq.com.testapplication.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16 0016.
 */

public class ActivityController {

    private static List<Activity> mActivities = new ArrayList<>();

    public static void addActivity(Activity activity){
        mActivities.add(activity);
    }

    public static void removeActivity(Activity activity){
        mActivities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : mActivities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
