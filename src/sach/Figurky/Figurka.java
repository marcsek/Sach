package sach.Figurky;

import java.io.Serializable;
import java.util.ArrayList;
import sach.Vec2;
import sach.Enums.TeamEnum;

import java.lang.Math;

public abstract class Figurka implements Serializable {
    public int x, y, hodnota;
    public TeamEnum team;
    protected transient ArrayList<int[]> kombinacie;
    public ArrayList<Vec2> deathZone = new ArrayList<Vec2>();

    protected Figurka(int x, int y, TeamEnum team) {
        this.y = y;
        this.x = x;
        this.team = team;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean skontrolujPohyb(int newX, int newY, Figurka[][] hraciePole) {
        for (int i = 0; i < deathZone.size(); i++) {
            if (deathZone.get(i).getY() == newY && deathZone.get(i).getX() == newX) {
                return true;
            }
        }
        return false;
    }

    public abstract void vypocitajDeathZone(Figurka[][] hraciePole);

    protected final ArrayList<int[]> generateKomb(int[] komb, boolean opakujuSa) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < komb.length; i++) {
            for (int j = 0; j < komb.length; j++) {
                if (!opakujuSa && Math.abs(komb[i]) == Math.abs(komb[j])) {
                    continue;
                }
                int[] combination = { komb[i], komb[j] };
                arrayList.add(combination);
            }
        }
        return arrayList;
    }
}
