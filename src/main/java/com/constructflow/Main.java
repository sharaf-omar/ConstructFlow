package com.constructflow;

import com.constructflow.boundary.notifications.*;
import com.constructflow.boundary.notifications.bridge.*;
import com.constructflow.boundary.reports.*;
import com.constructflow.boundary.reports.adapter.*;
import com.constructflow.boundary.reports.decorator.*;
import com.constructflow.controller.NotificationService;
import com.constructflow.dao.DatabaseConnector;
import com.constructflow.dao.ProjectRepository;
import com.constructflow.dao.bridge.*;
import com.constructflow.dao.adapter.*;
import com.constructflow.entity.Project;
import com.constructflow.entity.Resource;
import com.constructflow.entity.Task;
import com.constructflow.entity.factory.EquipmentFactory;
import com.constructflow.entity.factory.MaterialFactory;
import com.constructflow.entity.factory.ResourceFactory;
import com.constructflow.entity.flyweight.*;
import com.constructflow.entity.decorator.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("CONSTRUCTFLOW SYSTEM - DESIGN PATTERN TESTS");
        //db singleton test
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
        System.out.println("\n[Functional Test] Reading Projects from DB...");
        ProjectRepository repo = new ProjectRepository();
        List<Project> projects = repo.findAllProjects();
        if (!projects.isEmpty()) {
            System.out.println("[PASS] Successfully retrieved " + projects.size() + " projects via Singleton DAO.");
        } else {
            System.out.println("[WARN] No projects found (Check DB data).");
        }
        //noti singleton test
        System.out.println("\n--- TEST 2: SINGLETON PATTERN (NOTIFICATIONS) ---");
        NotificationService ns1 = NotificationService.getInstance();
        NotificationService ns2 = NotificationService.getInstance();

        if (ns1 == ns2) {
            System.out.println("[PASS] NotificationService Singleton Check: Verified.");
        }
        //factory method test
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

        //ABSTRACT FACTORY (NOTIFICATIONS) test
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
        LowStockAlert pushAlert = pushFactory.createLowStockAlert();
        pushReminder.send();
        pushAlert.send();


        //ABSTRACT FACTORY (REPORTING) test

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
        WorkloadReport excelWorkload = excelFactory.createWorkloadReport();
        excelSummary.generate();
        excelWorkload.generate();

        // --- NEW PATTERN TESTS ---
        
        System.out.println("\n\n========== ADVANCED DESIGN PATTERNS DEMONSTRATION ==========\n");

        // BRIDGE PATTERN - NOTIFICATIONS
        System.out.println("--- TEST 6: BRIDGE PATTERN (NOTIFICATIONS) ---");
        System.out.println("[Scenario] Dynamically switching notification delivery mechanisms\n");
        
        NotificationDelivery emailDelivery = new EmailDelivery();
        NotificationDelivery pushDelivery = new PushDelivery();
        
        AbstractNotification taskNotif = new TaskNotification(emailDelivery, "john.doe@company.com", 
                                                              "Foundation Work", "Complete foundation inspection");
        System.out.println("[Bridge] Initially using: " + taskNotif.getDeliveryType());
        taskNotif.send();
        
        System.out.println("\n[Bridge] Switching to Push delivery at runtime...");
        taskNotif.setDelivery(pushDelivery);
        System.out.println("[Bridge] Now using: " + taskNotif.getDeliveryType());
        taskNotif.send();
        
        AbstractNotification alertNotif = new AlertNotification(pushDelivery, "manager@company.com", 
                                                               "Low Stock Alert", "CRITICAL");
        System.out.println("\n[Bridge] Alert notification via " + alertNotif.getDeliveryType());
        alertNotif.send();

        // BRIDGE PATTERN - DATABASE
        System.out.println("\n--- TEST 7: BRIDGE PATTERN (DATABASE DRIVERS) ---");
        System.out.println("[Scenario] Supporting multiple database vendors\n");
        
        DatabaseDriver mssqlDriver = new MSSQLDriver();
        ProjectDatabase projectDB = new ProjectDatabase(mssqlDriver);
        
        if (projectDB.connect()) {
            System.out.println("[Bridge] Connected database: " + projectDB.getDriverType());
            projectDB.performQuery();
        }
        
        System.out.println("\n[Bridge] Switching to PostgreSQL driver...");
        DatabaseDriver postgresDriver = new PostgreSQLDriver("localhost", 5432, "constructflow", "user", "pass");
        projectDB.switchDriver(postgresDriver);
        System.out.println("[Bridge] New driver: " + projectDB.getDriverType());
        projectDB.disconnect();

        // ADAPTER PATTERN - REPORTING
        System.out.println("\n--- TEST 8: ADAPTER PATTERN (3RD-PARTY REPORT ENGINES) ---");
        System.out.println("[Scenario] Integrating Jasper Reports and Crystal Reports\n");
        
        System.out.println("[Adapter] Using Jasper Reports Engine:");
        ReportFactory jasperAdapter = new JasperReportAdapter();
        WorkloadReport jasperWorkload = jasperAdapter.createWorkloadReport();
        jasperWorkload.generate();
        
        System.out.println("\n[Adapter] Using Crystal Reports Engine:");
        ReportFactory crystalAdapter = new CrystalReportsAdapter();
        SummaryReport crystalSummary = crystalAdapter.createSummaryReport();
        crystalSummary.generate();

        // ADAPTER PATTERN - DATA IMPORT
        System.out.println("\n--- TEST 9: ADAPTER PATTERN (DATA IMPORT) ---");
        System.out.println("[Scenario] Converting external data formats to internal entities\n");
        
        // SAP XML Data
        String sapXmlData = "<project projectNumber='SAP001'>" +
                           "<description>Infrastructure Project</description>" +
                           "<location>Downtown Site</location>" +
                           "<startDate>2024-03-01</startDate>" +
                           "</project>";
        DataAdapter sapAdapter = new SAPDataAdapter();
        Project sapProject = sapAdapter.convertToProject(sapXmlData);
        System.out.println("[Adapter] Converted SAP project: " + sapProject.getProjectName());
        
        // Autodesk API Data
        Map<String, Object> autodeskData = new HashMap<>();
        autodeskData.put("urn", "AUTO001");
        autodeskData.put("name", "BIM Model - Tower A");
        autodeskData.put("address", "123 Construction Ave");
        autodeskData.put("createdDate", "2024-02-15");
        DataAdapter autodeskAdapter = new AutodeskDataAdapter();
        Project autodeskProject = autodeskAdapter.convertToProject(autodeskData);
        System.out.println("[Adapter] Converted Autodesk project: " + autodeskProject.getProjectName());
        
        // CSV Data
        String csvData = "CSV002\tBridgeConstruction\tNorth District\t2024-04-10";
        DataAdapter csvAdapter = new CSVDataAdapter();
        Project csvProject = csvAdapter.convertToProject(csvData);
        System.out.println("[Adapter] Converted CSV project: " + csvProject.getProjectName());

        // FLYWEIGHT PATTERN
        System.out.println("\n--- TEST 10: FLYWEIGHT PATTERN (OBJECT POOLING) ---");
        System.out.println("[Scenario] Optimizing memory for frequently-used objects\n");
        
        EmployeeFlyweightFactory employeeFactory = EmployeeFlyweightFactory.getInstance();
        EquipmentFlyweightFactory equipmentFactory2 = EquipmentFlyweightFactory.getInstance();
        MaterialFlyweightFactory materialFactory2 = MaterialFlyweightFactory.getInstance();
        
        System.out.println("[Flyweight] Creating employee references...");
        var john = employeeFactory.getEmployee(1, "John Smith", "Site Engineer");
        var jane = employeeFactory.getEmployee(2, "Jane Doe", "Project Manager");
        var john2 = employeeFactory.getEmployee(1, "John Smith", "Site Engineer"); // Reused!
        
        employeeFactory.printPoolStats();
        System.out.println("[Flyweight] Same object? " + (john == john2) + " (Memory optimized!)");
        System.out.println("[Flyweight] Using employee (extrinsic data passed at use-time)...");
        john.assignToTask("TASK-20", "Downtown Site", 8);
        
        System.out.println("\n[Flyweight] Creating equipment references...");
        var excavator2 = equipmentFactory2.getEquipment(101, "CAT 320", "Heavy Machinery");
        var loader = equipmentFactory2.getEquipment(102, "CAT L320", "Loader");
        var excavator3 = equipmentFactory2.getEquipment(101, "CAT 320", "Heavy Machinery"); // Reused!
        
        equipmentFactory2.printPoolStats();
        System.out.println("[Flyweight] Same excavator object? " + (excavator2 == excavator3));
        System.out.println("[Flyweight] Using equipment (extrinsic data passed at use-time)...");
        excavator2.useOnTask("TASK-30", "North Site", 6);

        System.out.println("\n[Flyweight] Creating material references...");
        var cement2 = materialFactory2.getMaterial(201, "Portland Cement (50kg)", "Consumable");
        var steel = materialFactory2.getMaterial(202, "Rebar Steel", "Structural");
        var cement3 = materialFactory2.getMaterial(201, "Portland Cement (50kg)", "Consumable"); // Reused!

        materialFactory2.printPoolStats();
        System.out.println("[Flyweight] Same material object? " + (cement2 == cement3));
        System.out.println("[Flyweight] Using material (extrinsic data passed at use-time)...");
        cement2.useOnTask("TASK-10", 50, "bags", "Downtown Site");

        // DECORATOR PATTERN - TASK AUGMENTATION
        System.out.println("\n--- TEST 11: DECORATOR PATTERN (TASK AUGMENTATION) ---");
        System.out.println("[Scenario] Dynamically adding behaviors to tasks\n");
        
        Task baseTask = new Task();
        baseTask.setTaskName("Foundation Inspection");
        baseTask.setStatus("Pending");
        
        System.out.println("[Decorator] Base task created");
        TaskComponent task = new ConcreteTaskComponent(baseTask);
        task.execute();
        
        System.out.println("\n[Decorator] Adding priority decoration...");
        task = new PriorityTaskDecorator(task, "HIGH");
        task.execute();
        System.out.println("Description: " + task.getDescription());
        
        System.out.println("\n[Decorator] Adding audit decoration...");
        AuditableTaskDecorator auditTask = new AuditableTaskDecorator(task);
        auditTask.execute();
        
        System.out.println("\n[Decorator] Adding access control...");
        RestrictedTaskDecorator restrictedTask = new RestrictedTaskDecorator(auditTask, "CONFIDENTIAL");
        restrictedTask.grantAccess("supervisor");
        System.out.println("Description: " + restrictedTask.getDescription());
        
        System.out.println("\n[Decorator] Executing with authorization:");
        restrictedTask.executeIfAuthorized("supervisor");
        
        System.out.println("\n[Decorator] Attempting unauthorized execution:");
        restrictedTask.executeIfAuthorized("unauthorized_user");

        // DECORATOR PATTERN - REPORT ENHANCEMENT
        System.out.println("\n--- TEST 12: DECORATOR PATTERN (REPORT ENHANCEMENT) ---");
        System.out.println("[Scenario] Composing report enhancements without class explosion\n");
        
        System.out.println("[Decorator] Base report factory");
        ReportFactory baseFactory = new PDFReportFactory();
        
        System.out.println("\n[Decorator] Adding watermark...");
        baseFactory = new WatermarkDecorator(baseFactory, "DRAFT");
        
        System.out.println("\n[Decorator] Adding timestamp...");
        baseFactory = new TimestampDecorator(baseFactory);
        
        System.out.println("\n[Decorator] Adding digital signature...");
        baseFactory = new DigitalSignatureDecorator(baseFactory, "/certs/construct.pfx", "Admin");
        
        System.out.println("\n[Decorator] Adding encryption...");
        baseFactory = new EncryptionDecorator(baseFactory, "SecurePass123");
        
        System.out.println("\n[Decorator] Adding metadata header...");
        baseFactory = new MetadataHeaderDecorator(baseFactory, "Downtown Construction", "John Doe");
        
        System.out.println("\n[Decorator] Generating fully decorated report:");
        WorkloadReport decoratedReport = baseFactory.createWorkloadReport();
        decoratedReport.generate();

        System.out.println("\n\n========== ALL PATTERN TESTS COMPLETED ==========");
        System.out.println("ALL SYSTEM TESTS COMPLETED");
    }
}