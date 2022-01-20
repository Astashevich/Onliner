package by.onliner.core.utils.recorder;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recorder extends ScreenRecorder {

    private final String name;

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
}
