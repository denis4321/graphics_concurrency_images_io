package io_example_;

import java.io.*;
import java.util.*;

public class MyListModelTransferable implements Serializable{
    private List<Element> elems;

    public MyListModelTransferable(List<Element> elems) {
        this.elems = elems;
    }

    public Object readResolve() throws ObjectStreamException{//Десерализуемый объект заменяется другим, который и возврощается как результат десерализации
        MyListModel model = new MyListModel();
        for (Element e : elems){
            model.addElement(e);
        }
        return model;
    }
}
