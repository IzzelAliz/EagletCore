package com.ilummc.eagletdl;

public class CompleteEvent {
    private EagletTask task;

    CompleteEvent(EagletTask task) {
        this.task = task;
    }

    public EagletTask getTask() {
        return task;
    }
}
