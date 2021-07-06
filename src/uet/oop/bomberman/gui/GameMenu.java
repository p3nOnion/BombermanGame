package uet.oop.bomberman.gui;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameMenu extends MenuBar {

    private Board _board;
    private Menu gameMe;
    private Menu levels;
    private Menu more;

    private MenuItem pauseItem;
    private MenuItem resumeItem;
    private MenuItem commandItem;
    private MenuItem about;
    private MenuItem help;
    private MenuItem[] levelItems;
    private MenuItem newgame;

    public GameMenu ( Board board ) {

        _board = board;
        gameMe = new Menu ( "Game" );
        levels = new Menu ( "Levels" );
        more = new Menu ( "More" );
        newgame = new MenuItem ( "New Game" );
        about = new MenuItem ( "About" );
        help = new MenuItem ( "Help" );
        commandItem = new MenuItem ( "Command" );
        pauseItem = new MenuItem ( "Pause" );
        resumeItem = new MenuItem ( "Resume" );
        resumeItem.setEnabled ( false );

        MenuShortcut game1 = new MenuShortcut ( 49 );
        MenuShortcut game2 = new MenuShortcut ( 50 );
        MenuShortcut game3 = new MenuShortcut ( 51 );
        MenuShortcut game4 = new MenuShortcut ( 52 );
        MenuShortcut game5 = new MenuShortcut ( 53 );


        MenuShortcut pauseShortcut = new MenuShortcut ( 0x50 );
        MenuShortcut resumeShortcut = new MenuShortcut ( 0x52 );
        MenuShortcut commandShortcut = new MenuShortcut ( 0x43 );
        MenuShortcut newgameShortcut = new MenuShortcut ( 78 );

        resumeItem.setShortcut ( resumeShortcut );
        pauseItem.setShortcut ( pauseShortcut );
        commandItem.setShortcut ( commandShortcut );
        newgame.setShortcut ( newgameShortcut );

        levelItems = new MenuItem[5];
        for (int i = 0; i < 5; i++) {
            int j = i + 1;
            String s = "game" + j;
            levelItems[i] = new MenuItem ( "Level " + j );
            levels.add ( levelItems[i] );

            if ( i > 0 )
                levelItems[i].setEnabled ( false );
        }
        levelItems[0].setShortcut ( game1 );
        levelItems[1].setShortcut ( game2 );
        levelItems[2].setShortcut ( game3 );
        levelItems[3].setShortcut ( game4 );
        levelItems[4].setShortcut ( game5 );


        levelItems[0].addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.loadLevel ( 1 );
            }
        } );
        levelItems[1].addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.loadLevel ( 2 );
            }
        } );
        levelItems[2].addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.loadLevel ( 3 );
            }
        } );
        levelItems[3].addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.loadLevel ( 4 );
            }
        } );
        levelItems[4].addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.loadLevel ( 5 );
            }
        } );
        newgame.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.set_points ( 0 );
                _board.set_lives ( 3 );
                _board.loadLevel ( 1 );
                for (int i = 0; i < 5; i++) {
                    Game.kt[i] = true;
                }
            }
        } );
        pauseItem.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.gamePause ();
                resumeItem.setEnabled ( true );
                pauseItem.setEnabled ( false );
            }
        } );
        resumeItem.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.gameResume ();
                resumeItem.setEnabled ( false );
                pauseItem.setEnabled ( true );
            }
        } );
        commandItem.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                String s = JOptionPane.showInputDialog ( null , "Your command" );
                if ( s != null && s.equals ( "open" ) )
                    _board.unlockLevels ();
            }
        } );
        help.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.gamePause ();
                JOptionPane.showMessageDialog ( null , "Use keyboard to play this game: " + "\n" + "Up/W --- Move up" + "\n" + "Down/S --- Move down" + "\n" + "Right/D --- Move Right" + "\n" + "Left/A --- Move left" + "\n" + "Space/X --- Place a bomb" , "Help" , JOptionPane.INFORMATION_MESSAGE );
                _board.gameResume ();
            }
        } );
        about.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                _board.gamePause ();
                JOptionPane.showMessageDialog ( null , "Base on following project: https://github.com/carlosflorencio/bomberman" + "\n" + "Rebuild by Phan Cơ : 19020235" , "About" , JOptionPane.INFORMATION_MESSAGE );
                _board.gameResume ();
            }
        } );

        more.add ( help );
        more.add ( about );
        gameMe.add ( newgame );
        gameMe.add ( pauseItem );
        gameMe.add ( resumeItem );
        gameMe.add ( commandItem );
        gameMe.add ( levels );

        this.add ( gameMe );
        this.add ( more );
    }

    public void update ( ) {
        for (int i = 0; i < 5; i++) {
            if ( (i + 1) <= _board.get_currentLevel () ) {
                levelItems[i].setEnabled ( true );
            }
        }
    }
}
