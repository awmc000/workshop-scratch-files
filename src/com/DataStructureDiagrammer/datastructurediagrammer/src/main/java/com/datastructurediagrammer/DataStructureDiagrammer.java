package com.datastructurediagrammer;

public abstract class DataStructureDiagrammer<DataStructure> {
    public abstract void renderDiagram(DataStructure ds, String filename);
}
