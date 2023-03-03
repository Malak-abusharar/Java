package employee;


import employee.Employee;
import employee.EmployeeList;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohamed
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public Form() throws IOException {
        initComponents();
        Show_Employees_In_JTable();
        getContentPane().setBackground(Color.pink);
    }
    int pos = 0;
    EmployeeList empList = getEmployeesList();

    // Check Input Fields
    public boolean checkInputs() {
        if (txt_name.getText() == null) {
            return false;
        } else {
            try {
                Integer.parseInt(txt_empNo.getText());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    // Display Data In JTable: 
    public EmployeeList getEmployeesList() throws IOException {
        EmployeeList empList = new EmployeeList();
        File file = new File("C:\\Users\\Mohammed\\Desktop\\Employee\\src\\employee\\EmployeesData.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while ((str = br.readLine()) != null) {
            String[] result = str.split(",");

            int EmployeeNumber = Integer.parseInt(result[0]);
            String EmployeeName = result[1];
            int EmployeeSalary = Integer.parseInt(result[2]);
            String EmployeeDOB = result[3];
            String EmployeeDepartment = result[4];

            Employee emp = new Employee(EmployeeNumber, EmployeeName, EmployeeSalary, EmployeeDOB, EmployeeDepartment);
            empList.append(emp);
        }
        return empList;
    }

    public void Show_Employees_In_JTable() throws IOException {
        ArrayList<Employee> list = empList.traverseInArrayList();
        DefaultTableModel model = (DefaultTableModel) JTable_Employees.getModel();
        // clear jtable content
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getEmp_No();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getSalary();
            row[3] = list.get(i).getDateOfBirth();
            row[4] = list.get(i).getDepartment();

            model.addRow(row);
        }
    }

    // Show Data In Inputs
    public void ShowItem(int index) throws IOException {
        ArrayList<Employee> list = empList.traverseInArrayList();

        txt_empNo.setText(Integer.toString(list.get(index).getEmp_No()));
        txt_name.setText(list.get(index).getName());
        txt_salary.setText(Integer.toString(list.get(index).getSalary()));
        txt_DOB.setText(list.get(index).getDateOfBirth());
        txt_department.setText(list.get(index).getDepartment());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_empNo = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_salary = new javax.swing.JTextField();
        txt_DOB = new javax.swing.JTextField();
        txt_department = new javax.swing.JTextField();
        Btn_Insert = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_mergeSort = new javax.swing.JButton();
        btn_insertionSort = new javax.swing.JButton();
        btn_selectionSort = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Employees = new javax.swing.JTable();
        Btn_linearSearch = new javax.swing.JButton();
        btn_binarySearch = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mamg System By Malak");
        setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel1.setText("Employee number");

        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel2.setText("Name");

        jLabel6.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel6.setText("Salary");

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel3.setText("Date Of Birth");

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 1, 24)); // NOI18N
        jLabel4.setText("Department");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salaryActionPerformed(evt);
            }
        });

        txt_DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DOBActionPerformed(evt);
            }
        });

        Btn_Insert.setBackground(java.awt.Color.pink);
        Btn_Insert.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        jButton3.setBackground(java.awt.Color.pink);
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_mergeSort.setBackground(java.awt.Color.pink);
        btn_mergeSort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_mergeSort.setText("Merge Sort");
        btn_mergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mergeSortActionPerformed(evt);
            }
        });

        btn_insertionSort.setBackground(java.awt.Color.pink);
        btn_insertionSort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_insertionSort.setText("Insertion Sort");
        btn_insertionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertionSortActionPerformed(evt);
            }
        });

        btn_selectionSort.setBackground(java.awt.Color.pink);
        btn_selectionSort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_selectionSort.setText("Selection Sort");
        btn_selectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectionSortActionPerformed(evt);
            }
        });

        Btn_First.setBackground(java.awt.Color.pink);
        Btn_First.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_Next.setBackground(java.awt.Color.pink);
        Btn_Next.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Previous.setBackground(java.awt.Color.pink);
        Btn_Previous.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_Previous.setText("Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });

        Btn_Last.setBackground(java.awt.Color.pink);
        Btn_Last.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        JTable_Employees.setBackground(java.awt.Color.pink);
        JTable_Employees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Number", "Name", "Salary", "Date of Birth", "Department"
            }
        ));
        JTable_Employees.setGridColor(java.awt.Color.pink);
        jScrollPane1.setViewportView(JTable_Employees);

        Btn_linearSearch.setBackground(java.awt.Color.pink);
        Btn_linearSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Btn_linearSearch.setText("Linear Search");
        Btn_linearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_linearSearchActionPerformed(evt);
            }
        });

        btn_binarySearch.setBackground(java.awt.Color.pink);
        btn_binarySearch.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_binarySearch.setText("Binary Search");
        btn_binarySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_binarySearchActionPerformed(evt);
            }
        });

        txt_search.setForeground(new java.awt.Color(204, 204, 204));
        txt_search.setText("Search with employee number ....");
        txt_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_searchMousePressed(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_department, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_empNo)
                                .addComponent(txt_DOB)
                                .addComponent(txt_salary)
                                .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_insertionSort)
                    .addComponent(btn_mergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_selectionSort))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_binarySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_linearSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(Btn_Previous)
                                .addGap(80, 80, 80)
                                .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_empNo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_insertionSort)
                                .addGap(38, 38, 38)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btn_selectionSort)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_mergeSort)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_binarySearch)
                            .addComponent(Btn_linearSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(239, 239, 239))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txt_department, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!txt_empNo.getText().equals("")) {

            try {

                int empNo = Integer.parseInt(txt_empNo.getText());
                empList.removeWithEmployeeNumber(empNo);
                Show_Employees_In_JTable();

                //file write to append in employees logs
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                StringBuilder sb = new StringBuilder();
                sb.append("Employee with id = " + empNo + " has been deleted at {" + formatter.format(new Date()) + "} \n");
                Files.write(Paths.get("C:\\Users\\Mohammed\\Desktop\\Employee\\src\\employee\\EmployeeList_Log.txt"), sb.toString().getBytes(), StandardOpenOption.APPEND);

                JOptionPane.showMessageDialog(null, "Employee with Number = " + empNo + " has been Deleted");

            } catch (HeadlessException | IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Employee Not Deleted : No Number To Delete");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        pos = 0;
        try {
            ShowItem(pos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed

        try {
            pos++;

            if (pos >= getEmployeesList().size()) {
                pos = getEmployeesList().size() - 1;
            }

            ShowItem(pos);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed

        try {
            pos--;

            if (pos < 0) {
                pos = 0;
            }

            ShowItem(pos);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed

        try {
            pos = getEmployeesList().size() - 1;
            ShowItem(pos);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        if (checkInputs()) {
            try {
                if (empList.linearSearch(Integer.parseInt(txt_empNo.getText())) != null) {
                    JOptionPane.showMessageDialog(null, "The Number of this employee is exist, please try another");
                } else {
                    Employee emp = new Employee(Integer.parseInt(txt_empNo.getText()), txt_name.getText(), Integer.parseInt(txt_salary.getText()), txt_DOB.getText(), txt_department.getText());
                    empList.append(emp);
                    Show_Employees_In_JTable();

                    //file write to append in employees logs
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Employee with id = " + emp.getEmp_No() + " ,and Name = " + emp.getName() + " has been Added at {" + formatter.format(new Date()) + "} \n");
                    Files.write(Paths.get("C:\\Users\\Mohammed\\Desktop\\Employee\\src\\employee\\EmployeeList_Log.txt"), sb.toString().getBytes(), StandardOpenOption.APPEND);

                    JOptionPane.showMessageDialog(null, "Employee with Name = " + emp.getName() + " has been Inserted");
                }
            } catch (HeadlessException | IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One Or More Field Are Empty");
        }

    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salaryActionPerformed

    private void txt_DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DOBActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed


    }//GEN-LAST:event_txt_searchActionPerformed

    private void Btn_linearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_linearSearchActionPerformed

        try {
            Employee employeeToFind = empList.linearSearch(Integer.parseInt(txt_search.getText()));
            if (employeeToFind != null) {

                DefaultTableModel model = (DefaultTableModel) JTable_Employees.getModel();
                // clear jtable content
                model.setRowCount(0);
                Object[] row = new Object[5];

                row[0] = employeeToFind.getEmp_No();
                row[1] = employeeToFind.getName();
                row[2] = employeeToFind.getSalary();
                row[3] = employeeToFind.getDateOfBirth();
                row[4] = employeeToFind.getDepartment();

                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "404: Employee with Number= " + Integer.parseInt(txt_search.getText()) + " is not exist");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_Btn_linearSearchActionPerformed

    private void btn_binarySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_binarySearchActionPerformed
        try {
            Employee employeeToFind = empList.binarySearch(Integer.parseInt(txt_search.getText()));
            if (employeeToFind != null) {

                DefaultTableModel model = (DefaultTableModel) JTable_Employees.getModel();
                // clear jtable content
                model.setRowCount(0);
                Object[] row = new Object[5];

                row[0] = employeeToFind.getEmp_No();
                row[1] = employeeToFind.getName();
                row[2] = employeeToFind.getSalary();
                row[3] = employeeToFind.getDateOfBirth();
                row[4] = employeeToFind.getDepartment();

                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "404: Employee with Number= " + Integer.parseInt(txt_search.getText()) + " is not exist");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btn_binarySearchActionPerformed

    private void btn_mergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mergeSortActionPerformed
        try {
            empList.mergeSort(empList.head);
            Show_Employees_In_JTable();
            JOptionPane.showMessageDialog(null, "The List has been sorted acendening acording to Merge sort algorithm depend in Employee Number");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_mergeSortActionPerformed

    private void btn_insertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertionSortActionPerformed
        try {
            empList.insertionSort();
            Show_Employees_In_JTable();
            JOptionPane.showMessageDialog(null, "The List has been sorted acendening acording to Insertion sort algorithm depend in Employee Number");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_insertionSortActionPerformed

    private void btn_selectionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectionSortActionPerformed
        try {
            empList.selectionSort();
            Show_Employees_In_JTable();
            JOptionPane.showMessageDialog(null, "The List has been sorted acendening acording to Selection sort algorithm depend in Employee Number");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_selectionSortActionPerformed

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        // TODO add your handling code here:
        if (txt_search.getForeground() != Color.BLACK) {
            if (txt_search.getText().equals("Search with employee number ....")) {
                txt_search.setText("");
            }
        }
        txt_search.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        if (txt_search.getText().isEmpty() == true) {
            txt_search.setText("Search with employee number ....");
            txt_search.setCaretPosition(0);
            txt_search.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_searchMousePressed
        // TODO add your handling code here:
        txt_search.setCaretPosition(0);
    }//GEN-LAST:event_txt_searchMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Form().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_linearSearch;
    private javax.swing.JTable JTable_Employees;
    private javax.swing.JButton btn_binarySearch;
    private javax.swing.JButton btn_insertionSort;
    private javax.swing.JButton btn_mergeSort;
    private javax.swing.JButton btn_selectionSort;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_DOB;
    private javax.swing.JTextField txt_department;
    private javax.swing.JTextField txt_empNo;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}