/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project4;

/**
 *
 * @author Binal Shah
 */
public class Grid {
	int leftofWall, rightofWall;
	String orientation;
	
	public Grid(String orientation,int leftofWall,int rightofWall)
	{
		this.orientation= orientation;
		this.leftofWall=leftofWall;
		this.rightofWall=rightofWall;
	}
}