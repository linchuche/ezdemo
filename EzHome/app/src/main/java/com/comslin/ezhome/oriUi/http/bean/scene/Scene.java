package com.comslin.ezhome.oriUi.http.bean.scene;

import android.os.Parcel;
import android.os.Parcelable;

public class Scene implements Parcelable {
    public static final String AUTO = "AUTO";
    public static final String MANUAL= "MANUAL";

    private SceneConditionList[] conditionList;
    private String sceneType;
    private String sceneName;
    private int sceneId;
    private String description;
    private SceneTaskList[] taskList;
    private String validTime;
    private String triggerType;
    private boolean enabled;

    public SceneConditionList[] getConditionList() {
        return this.conditionList;
    }

    public void setConditionList(SceneConditionList[] conditionList) {
        this.conditionList = conditionList;
    }

    public String getSceneType() {
        return this.sceneType;
    }

    public void setSceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getSceneName() {
        return this.sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SceneTaskList[] getTaskList() {
        return this.taskList;
    }

    public void setTaskList(SceneTaskList[] taskList) {
        this.taskList = taskList;
    }

    public String getValidTime() {
        return this.validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.conditionList, flags);
        dest.writeString(this.sceneType);
        dest.writeString(this.sceneName);
        dest.writeInt(this.sceneId);
        dest.writeString(this.description);
        dest.writeTypedArray(this.taskList, flags);
        dest.writeString(this.validTime);
        dest.writeString(this.triggerType);
        dest.writeByte(this.enabled ? (byte) 1 : (byte) 0);
    }

    public Scene() {
    }

    protected Scene(Parcel in) {
        this.conditionList = in.createTypedArray(SceneConditionList.CREATOR);
        this.sceneType = in.readString();
        this.sceneName = in.readString();
        this.sceneId = in.readInt();
        this.description = in.readString();
        this.taskList = in.createTypedArray(SceneTaskList.CREATOR);
        this.validTime = in.readString();
        this.triggerType = in.readString();
        this.enabled = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Scene> CREATOR = new Parcelable.Creator<Scene>() {
        @Override
        public Scene createFromParcel(Parcel source) {
            return new Scene(source);
        }

        @Override
        public Scene[] newArray(int size) {
            return new Scene[size];
        }
    };
}
