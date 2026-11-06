import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStoreApp extends JFrame {

    final int width = 500;
    final int height = 550;
    final int startp = 150;
    final int endp = 120;

    public void CreateGui() {

        JFrame frame = new JFrame("Bookstore Inventory System");

        JMenuBar menuBar = new JMenuBar();

        JMenu genreMenu = new JMenu("Book Genres");
        JMenu frameControl = new JMenu("Frame Controls");

        JMenuItem fictionItem = new JMenuItem("Fiction Books");
        JMenuItem nonFictionItem = new JMenuItem("Non-Fiction Books");
        JMenuItem scienceItem = new JMenuItem("Science Books");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem resetItem = new JMenuItem("Reset Fields");

        genreMenu.add(fictionItem);
        genreMenu.add(nonFictionItem);
        genreMenu.add(scienceItem);

        frameControl.add(exitItem);
        frameControl.add(resetItem);

        menuBar.add(genreMenu);
        menuBar.add(frameControl);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


        fictionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Fiction Books\n- The Great Gatsby\n- To Kill a Mockingbird\n");
            }
        });

        // Non-Fiction menu item event
        nonFictionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Non-Fiction Books\n- Sapiens\n- Educated\n");
            }
        });

        // Science menu item event
        scienceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Science Books\n- A Brief History of Time\n- Cosmos\n");
            }
        });

        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // Exit option with confirmation dialog
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(startp, endp);
        frame.setVisible(true);
    }
}
