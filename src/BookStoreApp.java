import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        JMenuItem saveItem = new JMenuItem("Save Report");

        genreMenu.add(fictionItem);
        genreMenu.add(nonFictionItem);
        genreMenu.add(scienceItem);

        frameControl.add(saveItem);
        frameControl.add(resetItem);
        frameControl.add(exitItem);

        menuBar.add(genreMenu);
        menuBar.add(frameControl);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        fictionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Fiction Books\n- The Great Gatsby\n- To Kill a Mockingbird\n- 1984\n");
            }
        });

        nonFictionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Non-Fiction Books\n- Sapiens: A Brief History of Humankind\n- Educated by Tara Westover\n- Atomic Habits\n");
            }
        });

        scienceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Selected Genre: Science Books\n- A Brief History of Time by Stephen Hawking\n- Cosmos by Carl Sagan\n- The Selfish Gene\n");
            }
        });

        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nothing to save! Please select a genre first.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                int userSelection = fileChooser.showSaveDialog(frame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try (FileWriter writer = new FileWriter(fileToSave.getAbsolutePath() + ".txt")) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(frame, "Report successfully saved to:\n" + fileToSave.getAbsolutePath() + ".txt", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

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