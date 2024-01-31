package deportesmiguel.manager.mainpackage.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.StringJoiner;

public class Player implements Serializable {
    private String name;
    private String surname;
    private int dorsal;
    private Date birthDate;
    private String position;
    private int image;

    public Player(String name, String surname, int dorsal, Date birthDate, String position, int image) {
        this.name = name;
        this.surname = surname;
        this.dorsal = dorsal;
        this.birthDate = birthDate;
        this.position = position;
        this.image = image;
    }

    public Player(String name, String surname, int dorsal, Date birthDate, String position) {
        this.name = name;
        this.surname = surname;
        this.dorsal = dorsal;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Player(String name, String surname, int dorsal, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.dorsal = dorsal;
        this.birthDate = birthDate;
    }

    @NonNull
    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]").add("name='" + name + "'").add("surname='" + surname + "'").add("dorsal=" + dorsal).add("birthDate=" + birthDate).add("position='" + position + "'").toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Player) {
            //cast obj to Player
            Player player = (Player) obj;
            //compare name, surname, dorsal and birthDate
            return this.name.equals(player.name) && this.surname.equals(player.surname) && this.dorsal == player.dorsal && this.birthDate.equals(player.birthDate);
        } else {
            return super.equals(obj);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
