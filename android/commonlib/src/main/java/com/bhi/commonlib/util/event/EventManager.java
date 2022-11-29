package com.bhi.commonlib.util.event;

import android.util.Log;

import androidx.annotation.UiThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import timber.log.Timber;

/**
 * @author rahul rastogi
 * <p/>
 * This class is used to perform various event handling operations.
 * You can register your listeners in any class and call them from anywhere once registered
 * just like broadcasting an event in-app only.
 */
public class EventManager {

    private static final String TAG = "EventManager";

    private static List<Object> mListManagers = new ArrayList<>();
    private static Map<Class<? extends BaseUiListener>, List<BaseUiListener>> mMapUiListeners = new HashMap<>();

    /**
     * Registers UI listener
     */
    public static <T extends BaseUiListener> void registerUiListener(T listener, Class<T> listenerType) {
        if (null != mMapUiListeners.get(listenerType)) {
            mMapUiListeners.get(listenerType).add(listener);
        } else {
            List<BaseUiListener> list = new ArrayList<>();
            list.add(listener);

            mMapUiListeners.put(listenerType, list);
        }
    }


    /**
     * Unregisters UI listener
     */
    public static <T extends BaseUiListener> void unRegisterUiListener(T listener, Class<T> listenerType) {
        if (null != mMapUiListeners.get(listenerType)) {
            List<BaseUiListener> list = mMapUiListeners.get(listenerType);

            if (null != list) {
                //for each listener of this type
                for (int i = 0; i < list.size(); i++) {
                    if (listener.equals(list.get(i))) {
                        list.remove(i);
                        break;
                    }
                }
            }
        }
    }


    /**
     * Returns a list of particular type of UI listeners
     */
    @SuppressWarnings("unchecked")
    @UiThread
    public static <T> List<T> getUiListeners(Class<T> listenerClass) {
        List<T> listResult = new ArrayList<>();
        List<BaseUiListener> dataList = mMapUiListeners.get(listenerClass);

        //If listener found in mMapUiListeners
        if (null != dataList) {
            for (BaseUiListener l : dataList) {
                if (null != l) {
                    T listener = (T) l;
                    listResult.add(listener);
                } else {
                    Log.d(TAG, "Listener has been null");
                }
            }
        } else {
            Log.d(TAG, "Invalid Listener trying to get");
        }

        return listResult;
    }


    /**
     * Registers a manager class
     */
    public static void registerManager(Object manager) {
        mListManagers.add(manager);
    }

    /**
     * Un-registers a manager class
     */
    public static void unRegisterManager(Object manager) {
        mListManagers.remove(manager);
    }

    /**
     * Returns a list of registered manager listeners
     */
    public static <T> List<T> getBaseListener(Class<T> listenerType) {
        List<T> resultList = new ArrayList<>();

        //For all managers
        for (Object manager : mListManagers) {
            T listener = null;

            try {
                listener = (T) manager;
            } catch (Exception e) {
                e.printStackTrace();
                Timber.d("Manager not type casted:" + manager);
            }

            if (listener != null) {
                resultList.add(listener);
            }
        }

        return resultList;
    }


}
