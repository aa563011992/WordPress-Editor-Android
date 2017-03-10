package org.wordpress.android.editor;

import android.support.annotation.Nullable;

import org.wordpress.android.fluxc.model.PostModel;
import org.wordpress.android.util.helpers.MediaFile;

/**
 * Callbacks - requests for editor capabilities to replace media once it's finished uploading
 */
public interface EditorMediaUploadReadyListener {
    PostModel replaceMediaFileWithUrlInPost(@Nullable PostModel post, final String localMediaId, final MediaFile mediaFile);
}
