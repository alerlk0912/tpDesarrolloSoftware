/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

public class ModeSelection {
    public final boolean useJDBC;
    public final String username;
    public final String password;

    public ModeSelection(boolean useJDBC, String username, String password) {
        this.useJDBC = useJDBC;
        this.username = username;
        this.password = password;
    }
}
