package com.comslin.ezhome.oriUi.http.bean.scene;

public class Scene {
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
}
