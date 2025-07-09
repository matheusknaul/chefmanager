package com.chefmanager.common.datatransfer;

public enum RecipeNoteStatus {

    MAIN,

    ACTIVE,

    OBSOLETE;

    public int getPriority(){
        return switch(this){
          case MAIN -> 0;
          case ACTIVE -> 1;
          case OBSOLETE -> 2;
        };
    }
}
