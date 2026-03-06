package com.constructflow;

import com.constructflow.boundary.notifications.*;
import com.constructflow.boundary.reports.*;
import com.constructflow.controller.NotificationService;
import com.constructflow.dao.DatabaseConnector;
import com.constructflow.dao.ProjectRepository;
import com.constructflow.entity.Project;
import com.constructflow.entity.Resource;
import com.constructflow.entity.factory.EquipmentFactory;
import com.constructflow.entity.factory.MaterialFactory;
import com.constructflow.entity.factory.ResourceFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("   CONSTRUCTFLOW SYSTEM - DESIGN PATTERN TESTS");
        System.out.println("===========================================\n");

        // ---------------------------------------------------------
        // PATTERN 1: SINGLETON (DATABASE CONNECTION)
        // ---------------------------------------------------------
        System.out.println("--- TEST 1: SINGLETON PATTERN (DATABASE) ---");
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();

        try {
            Connection conn = db1.getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("[PASS] Database Connection Established.");
            } else {
                System.err.println("[FAIL] Database Connection Failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (db1 == db2) {
            System.out.println("[PASS] Singleton Instance Check: Both references point to the same object.");
        } else {
            System.err.println("[FAIL] Singleton Instance Check Failed!");
        }

        // Functional Test: Read Data using the Singleton Connection
        System.out.println("\n[Functional Test] Reading Projects from DB...");
        ProjectRepository repo = new ProjectRepository();
        List<Project> projects = repo.findAllProjects();
        if (!projects.isEmpty()) {
            System.out.println("[PASS] Successfully retrieved " + projects.size() + " projects via Singleton DAO.");
        } else {
            System.out.println("[WARN] No projects found (Check DB data).");
        }


        // ---------------------------------------------------------
        // PATTERN 2: SINGLETON (NOTIFICATION SERVICE)
        // ---------------------------------------------------------
        System.out.println("\n--- TEST 2: SINGLETON PATTERN (NOTIFICATIONS) ---");
        NotificationService ns1 = NotificationService.getInstance();
        NotificationService ns2 = NotificationService.getInstance();

        if (ns1 == ns2) {
            System.out.println("[PASS] NotificationService Singleton Check: Verified.");
        }

        // ---------------------------------------------------------
        // PATTERN 3: FACTORY METHOD (RESOURCE CREATION)
        // ---------------------------------------------------------
        System.out.println("\n--- TEST 3: FACTORY METHOD PATTERN (RESOURCES) ---");

        // Test Material Factory
        ResourceFactory materialFactory = new MaterialFactory();
        Resource cement = materialFactory.createResource();
        cement.setName("Portland Cement (50kg)");
        cement.displayInfo(); // Should print "[Factory Method] Material (Consumable)..."

        // Test Equipment Factory
        ResourceFactory equipmentFactory = new EquipmentFactory();
        Resource excavator = equipmentFactory.createResource();
        excavator.setName("CAT 320 Excavator");
        excavator.displayInfo(); // Should print "[Factory Method] Equipment (Reusable)..."


        // ---------------------------------------------------------
        // PATTERN 4: ABSTRACT FACTORY (NOTIFICATIONS)
        // ---------------------------------------------------------
        System.out.println("\n--- TEST 4: ABSTRACT FACTORY PATTERN (NOTIFICATIONS) ---");

        // Scenario A: Manager wants EMAIL notifications
        System.out.println("[Scenario A] User preferences set to EMAIL:");
        NotificationChannelFactory emailFactory = new EmailChannelFactory();
        TaskReminder emailReminder = emailFactory.createTaskReminder();
        LowStockAlert emailAlert = emailFactory.createLowStockAlert();

        emailReminder.send();
        emailAlert.send();

        // Scenario B: Site Engineer wants PUSH notifications
        System.out.println("\n[Scenario B] User preferences set to PUSH (Mobile):");
        NotificationChannelFactory pushFactory = new PushChannelFactory();
        TaskReminder pushReminder = pushFactory.createTaskReminder();
        pushReminder.send();


        // ---------------------------------------------------------
        // PATTERN 5: ABSTRACT FACTORY (REPORTING)
        // ---------------------------------------------------------
        System.out.println("\n--- TEST 5: ABSTRACT FACTORY PATTERN (REPORTING) ---");

        // Scenario A: Client requests PDF Reports
        System.out.println("[Scenario A] Generating Monthly Reports in PDF Format:");
        ReportFactory pdfFactory = new PDFReportFactory();
        WorkloadReport pdfWorkload = pdfFactory.createWorkloadReport();
        SummaryReport pdfSummary = pdfFactory.createSummaryReport();

        pdfWorkload.generate();
        pdfSummary.generate();

        // Scenario B: Admin requests Excel Reports for Data Analysis
        System.out.println("\n[Scenario B] Generating Data Export in EXCEL Format:");
        ReportFactory excelFactory = new ExcelReportFactory();
        SummaryReport excelSummary = excelFactory.createSummaryReport();
        excelSummary.generate();

        System.out.println("\n===========================================");
        System.out.println("      ALL SYSTEM TESTS COMPLETED");
        System.out.println("===========================================");
    }
}