import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateMenu implements State, ActionListener {

    private JPanel menuPanel;
    private Board board;

    public StateMenu(Board board){
        this.board = board;

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));

        //Main menu text label
        JLabel header = new JLabel();
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setMaximumSize(Constants.HEADER_SIZE);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setText(Strings.MENU_HEADER);
        header.setFont(Constants.FONT_HEADER);
        header.setVisible(true);
        menuPanel.add(header);

        //Margin between header and start button
        menuPanel.add(Box.createRigidArea(Constants.HEADER_BUTTON_PADDING));

        //Start game button
        JButton startButton = new JButton();
        startButton.setActionCommand(Strings.ACTION_GAME);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setMaximumSize(Constants.BUTTON_SIZE);
        startButton.setText(Strings.MENU_BUTTON_START);
        startButton.setFont(Constants.FONT_BUTTON);
        startButton.setVisible(true);
        menuPanel.add(startButton);

        //Margin between buttons
        menuPanel.add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //About button
        JButton aboutButton = new JButton();
        aboutButton.setActionCommand(Strings.ACTION_SCORES_BOARD);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setMaximumSize(Constants.BUTTON_SIZE);
        aboutButton.setText(Strings.MENU_BUTTON_SCORES_BOARD);
        aboutButton.setFont(Constants.FONT_BUTTON);
        aboutButton.setVisible(true);
        menuPanel.add(aboutButton);

        //Margin between buttons
        menuPanel.add(Box.createRigidArea(Constants.BUTTON_PADDING));

        //Credits button
        JButton creditsButton = new JButton();
        creditsButton.setActionCommand(Strings.ACTION_QUIT);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setMaximumSize(Constants.BUTTON_SIZE);
        creditsButton.setText(Strings.MENU_BUTTON_QUIT);
        creditsButton.setFont(Constants.FONT_BUTTON);
        creditsButton.setVisible(true);
        menuPanel.add(creditsButton);

        //action listeners for the buttons refer to actionPerformed method
        startButton.addActionListener(this);
        aboutButton.addActionListener(this);
        creditsButton.addActionListener(this);
    }

    public JPanel getMainPanel(){
        return menuPanel;
    }

    /**
     * Handles the click events on the buttons
     * @param actionEvent Reference to the event. Uses the same string as is displayed on the button to identify it.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case Strings.ACTION_GAME:
                new Board().setVisible(true);
                break;
            case Strings.ACTION_SCORES_BOARD:
                board.setCurrentState(new StateScoresBoard(board));
                break;
            case Strings.ACTION_QUIT:
                board.setCurrentState(new StateQuit(board));
                break;
            default:
                break;
        }
    }
}