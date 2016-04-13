package org.domeos.framework.api.service.image;

import org.domeos.basemodel.HttpResponseTemp;
import org.domeos.framework.api.model.ci.related.BuildStatus;
import org.domeos.framework.api.model.image.BaseImageCustom;
import org.domeos.framework.engine.exception.DaoException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kairen on 29/02/16.
 */
public interface BaseImageCustomService {
    /**
     * get all build infos of a project in database
     * @param baseImageCustom can be found in api/model/ci/BaseImageCustom
     *
     * @return
     */
    HttpResponseTemp<?> addBaseImageCustom(String username, BaseImageCustom baseImageCustom);

    /**
     * build a base image custom started by user
     * @param imageId the Id of baseImageCustom
     * @return
     */
    HttpResponseTemp<?> startBuild(int imageId, long userId);

    /**
     * use md5 and the id of a base image custom to download file
     * this is used by ImageBuilder
     * @param md5 the md5 of a file
     * @param secret the secret generated by the image
     * @param imageId the id of the custom base image
     * @return
     */
    byte[] downloadFile(String md5, String secret, int imageId);

    /**
     * get the file info of a base custom image
     * this is used by ImageBuilder
     * @param secret the secret generated by the image
     * @param imageId the id of the custom base image
     * @return
     */
    String getFileJson(String secret, int imageId);

    /**
     * upload the log file of image build
     * this is used by ImageBuilder
     * @param body the log file body
     * @param imageId the id of the base image custom
     * @param secret the secret generated by the image
     * @return
     */
    HttpResponseTemp<?> uploadLogfile(MultipartFile body, int imageId, String secret) throws DaoException;

    /**
     * download log file api
     * @param imageId the id of base image custom
     * @param userId
     * @return
     */
    HttpResponseTemp<?> downloadLogFile(int imageId, long userId);

    /**
     * set build status of the image build
     * this is used by ImageBuilder
     * @param buildStatus can be found in api/ci/BuildStatus.java
     * @param secret the secret generated by the image
     * @return
     */
    HttpResponseTemp<?> setBuildStatus(BuildStatus buildStatus, String secret);

    /**
     * list all the base image custom info
     * @param userId
     * @return
     */
    HttpResponseTemp<?> listBaseImageCustomInfo(long userId);

    /**
     * get the content of some file
     * @param userId
     * @param baseImageCustom can be find in api/model/ci/BaseImageCustom.java
     * @param docMD5 the md5 of one file
     * @return
     */
    HttpResponseTemp<?> previewFile(long userId, BaseImageCustom baseImageCustom, String docMD5);

    /**
     * modify and generate a new custom base image
     * @param userId
     * @param baseImageCustom can be found in api/ci/BaseImageCustom.java
     * @return
     */
    HttpResponseTemp<?> modifyBaseImageCustom(long userId, String username, BaseImageCustom baseImageCustom);

    /**
     * delete the custom base image
     * @param userId
     * @param userId can be found in api/ci/BaseImageCustom.java
     * @return
     */
    HttpResponseTemp<?> deleteBaseImageCustom(long userId, int imageId);

    /**
     * validate the imageName and imageTag is duplicate
     * find the imageName and imageTag duplicate with base image
     * find the imageName duplicate with the projectBasic
     * @param userId
     * @param imageName
     * @param imageTag
     * @return
     */
    HttpResponseTemp<?> validation(long userId, String imageName, String imageTag);

    /**
     * get the detailed info of a custom base image
     * @param id
     * @return
     */
    HttpResponseTemp<?> getBaseImageCustomInfo(int id);

    /**
     *
     * @param secret
     * @param imageId
     * @return
     */
    String downloadDockerfile(String secret, int imageId);
}