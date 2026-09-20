import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketMachineGUI extends JFrame {
    private final TicketMachine machine;

    private StatCard priceCard;
    private StatCard balanceCard;
    private StatCard totalCard;
    private JTextField amountField;
    private JTextArea logArea;

    public TicketMachineGUI() {
        machine = new TicketMachine(500);

        setTitle("Ticket Machine");
        setSize(860, 620);
        setMinimumSize(new Dimension(720, 520));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        GradientPanel rootPanel = new GradientPanel(new Color(236, 242, 255), new Color(176, 196, 255));
        rootPanel.setBorder(new EmptyBorder(18, 18, 18, 18));
        rootPanel.setLayout(new BorderLayout(16, 16));
        setContentPane(rootPanel);

        JLabel titleLabel = new JLabel("Ticket Machine");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(new Color(23, 37, 84));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel("Control Center");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(76, 93, 133));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BorderLayout(4, 4));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);
        rootPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel statPanel = new JPanel(new GridLayout(3, 1, 10, 12));
        statPanel.setOpaque(false);

        priceCard = new StatCard("Ticket Price", TicketMachine.formatMoney(machine.getPrice()) + "", new Color(22, 101, 216));
        balanceCard = new StatCard("Balance", TicketMachine.formatMoney(machine.getBalance()) + "", new Color(5, 150, 105));
        totalCard = new StatCard("Total", TicketMachine.formatMoney(machine.getTotal()) + "", new Color(168, 85, 247));

        statPanel.add(priceCard);
        statPanel.add(balanceCard);
        statPanel.add(totalCard);

        JPanel leftPanel = new JPanel(new BorderLayout(12, 12));
        leftPanel.setOpaque(false);
        leftPanel.add(statPanel, BorderLayout.NORTH);

        JPanel actionPanel = new JPanel();
        actionPanel.setOpaque(false);
        actionPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 0, 6, 0);
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel insertPanel = new JPanel(new BorderLayout(8, 0));
        insertPanel.setOpaque(false);
        insertPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(117, 136, 204), 1, true),
                "Insert Cash",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(28, 52, 96))
        );

        amountField = new JTextField("100");
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        amountField.setPreferredSize(new Dimension(150, 36));
        amountField.setHorizontalAlignment(SwingConstants.CENTER);
        amountField.setBackground(new Color(245, 247, 255));
        amountField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(157, 172, 226), 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8))
        );

        JButton insertButton = createActionButton("Insert Money", new Color(52, 152, 219), new Color(41, 98, 255));
        insertPanel.add(amountField, BorderLayout.CENTER);
        insertPanel.add(insertButton, BorderLayout.EAST);

        JButton printButton = createActionButton("Print Ticket", new Color(16, 185, 129), new Color(5, 150, 105));
        JButton promptButton = createActionButton("Show Prompt", new Color(245, 158, 11), new Color(217, 119, 6));
        JButton emptyButton = createActionButton("Empty Machine", new Color(239, 68, 68), new Color(190, 24, 93));

        actionPanel.add(insertPanel, gbc);
        gbc.gridy = 1;
        actionPanel.add(printButton, gbc);
        gbc.gridy = 2;
        actionPanel.add(promptButton, gbc);
        gbc.gridy = 3;
        actionPanel.add(emptyButton, gbc);

        leftPanel.add(actionPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout(8, 8));
        outputPanel.setOpaque(false);
        logArea = new JTextArea(12, 26);
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        logArea.setBackground(new Color(18, 29, 53));
        logArea.setForeground(new Color(233, 238, 255));
        logArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        logArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(82, 103, 153), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10))
        );

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(108, 127, 178), 1),
                "Machine Output",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(28, 52, 96))
        );
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout(18, 0));
        mainPanel.setOpaque(false);
        mainPanel.add(leftPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.EAST);
        rootPanel.add(mainPanel, BorderLayout.CENTER);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText().trim());
                    if (amount <= 0) {
                        logArea.append("Error: Please insert a positive amount.\n");
                    } else {
                        machine.insertMoney(amount);
                        logArea.append("Inserted: " + TicketMachine.formatMoney(amount) + "\n");
                    }
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TicketMachineGUI.this,
                            "Please enter a valid number for the amount.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double missing = machine.getPrice() - machine.getBalance();
                if (missing > 0) {
                    logArea.append("You must insert at least another " + TicketMachine.formatMoney(missing) + "\n");
                    return;
                }

                machine.printTicket();
                logArea.append("Amount is enough. You can buy the ticket.\n");
                logArea.append("##################\n");
                logArea.append("# Ticket\n");
                logArea.append("# " + TicketMachine.formatMoney(machine.getPrice()) + "\n");
                logArea.append("##################\n\n");
                updateDisplay();
            }
        });

        promptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double missing = machine.getPrice() - machine.getBalance();
                if (missing > 0) {
                    logArea.append("Prompt: Please insert at least another " + TicketMachine.formatMoney(missing) + "\n");
                } else {
                    logArea.append("Prompt: Amount is enough. You can buy the ticket.\n");
                }
            }
        });

        emptyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double collected = machine.emptyMachine();
                logArea.append("Machine emptied. Collected: " + TicketMachine.formatMoney(collected) + "\n");
                updateDisplay();
            }
        });

        logArea.append("Ticket Machine initialized with price: " + TicketMachine.formatMoney(machine.getPrice()) + "\n");
    }

    private static class StatCard extends JPanel {
        private final JLabel valueLabel;

        StatCard(String labelText, String valueText, Color accentColor) {
            setOpaque(true);
            setBackground(new Color(255, 255, 255, 220));
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(157, 172, 226), 1, true),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12))
            );
            setLayout(new BorderLayout(4, 4));

            JLabel title = new JLabel(labelText);
            title.setFont(new Font("Segoe UI", Font.BOLD, 11));
            title.setForeground(new Color(77, 94, 135));

            valueLabel = new JLabel(valueText);
            valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            valueLabel.setForeground(accentColor);

            add(title, BorderLayout.NORTH);
            add(valueLabel, BorderLayout.CENTER);
        }

        void update(String value) {
            valueLabel.setText(value);
        }
    }

    private JButton createActionButton(String text, Color start, Color end) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 18, 12, 18));
        button.setBackground(start);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(end);
        return button;
    }

    private void updateDisplay() {
        priceCard.update(TicketMachine.formatMoney(machine.getPrice()));
        balanceCard.update(TicketMachine.formatMoney(machine.getBalance()));
        totalCard.update(TicketMachine.formatMoney(machine.getTotal()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicketMachineGUI().setVisible(true);
            }
        });
    }

    private static class GradientPanel extends JPanel {
        private final Color topColor;
        private final Color bottomColor;

        GradientPanel(Color topColor, Color bottomColor) {
            this.topColor = topColor;
            this.bottomColor = bottomColor;
            setOpaque(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, topColor, 0, height, bottomColor);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
            g2d.dispose();
        }
    }
}