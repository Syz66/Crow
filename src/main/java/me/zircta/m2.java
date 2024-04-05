package me.zircta;

import java.util.ArrayList;
import java.util.List;

public class m2 {
    static List<bb> modsList;

    public m2() {
        modsList = new ArrayList<bb>();
    }

    public void r3g1st3r() {
        this.register(new aq());
        this.register(new aj());
        this.register(new au());
        this.register(new ax());
        this.register(new a8());
        this.register(new af());
        this.register(new a());
        this.register(new al());
        this.register(new aa());
        this.register(new ao());
        this.register(new an());
    }

    private void register(bb mod) {
        modsList.add(mod);
    }

    public List<bb> listofmods() {
        return modsList;
    }

    public List<bb> inCategory(bb.category theCategories) {
        ArrayList<bb> perCategoryModList = new ArrayList<bb>();
        for (bb mod : this.listofmods()) {
            if (!mod.moduleCategory().equals((Object)theCategories)) continue;
            perCategoryModList.add(mod);
        }
        return perCategoryModList;
    }
}

