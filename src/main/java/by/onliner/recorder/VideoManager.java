package by.onliner.recorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class VideoManager {

    private static final ThreadLocal<VideoRecorder> threadRecorder = new ThreadLocal<>();
    private static final List<VideoRecorder> recorders = Collections.synchronizedList(new LinkedList<>());

    protected static final Logger logger = LogManager.getLogger(VideoManager.class);

    public static VideoRecorder getVideoRecorder() {
        if (null == threadRecorder.get()) {
            getNewRecorder();
        }
        return threadRecorder.get();
    }

    public static void setDefaultDriver(VideoRecorder recorder) {
        threadRecorder.set(recorder);
    }

    /**
     * Close default recorder
     */
    public static void stopDefaultRecording(String name) {
        VideoRecorder current = threadRecorder.get();
        if (null != current) {
            current.stopRecording(name);
            recorders.remove(current);
        }
        threadRecorder.set(null);
    }

    public static boolean isThreadRecorderOpened() {
        return null != threadRecorder.get();
    }

    private static VideoRecorder getNewRecorder() {
        logger.debug("Create new instance of Recorder");
        VideoRecorder recorder = new VideoRecorder();
        recorders.add(recorder);
        threadRecorder.set(recorder);
        return recorder;
    }
}
