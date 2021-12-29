package by.onliner.listener;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import ws.schild.jave.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static by.onliner.constants.FilePathConstants.SAVE_VIDEO_PATH;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/***
 * The class is used to record screen and convert video to mp4 format.
 */
public class Recorder extends ScreenRecorder {

    private ScreenRecorder screenRecorder;
    private String name;

    private static final String CODEC_LIBX264 = "libx264";
    private static final int BITRATE = 3200000;
    private static final int FRAMERATE = 15;
    private static final String FORMAT_MP4 = "mp4";
    private static final int DEPTH = 24;
    private static final int RATIONAL_15 = 15;
    private static final float QUALITY = 1.0f;
    private static final int FRAME_INTERVAL = 15 * 60;
    private static final String ENCODING = "black";
    private static final int RATIONAL_30 = 30;
    private static final String STORE_FORMAT_MP4 = ".mp4";

    /***
     * Setting video recorder
     * @param cfg graphics configuration
     * @param captureArea capture size
     * @param fileFormat format of the file
     * @param screenFormat format of the screen
     * @param mouseFormat format of the mouse
     * @param audioFormat audio format
     * @param movieFolder movie file
     * @param name method name
     */
    public Recorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                    Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        this.name = name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat);
    }

    public Recorder(GraphicsConfiguration cfg) throws IOException, AWTException {
        super(cfg);
    }

    /***
     * Creates a file for recording the movie.
     * @param fileFormat format of the file
     * @return created file
     */
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException(String.format("{%s} is not a directory.", movieFolder));
        }
        return new File(movieFolder, name);
    }

    /***
     * Initialise recorder and start recording test
     * @param name method name
     */
    public void startRecording(String name) throws IOException, AWTException {
        File file = new File(SAVE_VIDEO_PATH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new Recorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, DEPTH, FrameRateKey,
                        Rational.valueOf(RATIONAL_15), QualityKey, QUALITY, KeyFrameIntervalKey, FRAME_INTERVAL),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING, FrameRateKey, Rational.valueOf(RATIONAL_30)),
                null, file, name);

        screenRecorder.start();
    }

    /***
     * Stoped recording test
     * @param name method name
     */
    public void stopRecording(String name) throws IOException {
        screenRecorder.stop();
        aviToMp4(name);
    }

    /***
     * Converts avi to mp4 video format
     * @param name file name
     */
    private void aviToMp4(String name) {
        File source = new File(SAVE_VIDEO_PATH + name);
        File target = new File(SAVE_VIDEO_PATH + name + STORE_FORMAT_MP4);
        VideoAttributes video = new VideoAttributes();
        video.setCodec(CODEC_LIBX264);
        video.setBitRate(BITRATE);
        video.setFrameRate(FRAMERATE);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat(FORMAT_MP4);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            encoder.encode(multimediaObject, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
    }
}
