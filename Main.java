import java.util.*;

public class Main {
public static void main(String args[]) {
String userName = "aloka";
String password = "1234";
clearConsole();
String[][] supplier = new String[0][2]; // supplier array
loginPage(userName, password, supplier);
credentilManage(userName, password, supplier);
}
private final static void clearConsole() {
final String os = System.getProperty("os.name");
try {
if (os.equals("Linux")) {
System.out.print("\033\143");
} else if (os.equals("Windows")) {
new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
} else {
System.out.print("\033[H\033[2J");
System.out.flush();
}
} catch (final Exception e) {
// handle the exception
System.err.println(e.getMessage());
}
}
public static void loginPage(String userName, String password, String[][] supplier) {
Scanner scanner = new Scanner(System.in);
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| LOGIN PAGE |");
System.out.println("+-----------------------------------------------------------------------------+\n");
String inputUserName;
String inputPassWord;
do {
System.out.print("User Name : ");
inputUserName = scanner.next();
if (!userName.equals(inputUserName)) {
System.out.println("User name is invalid. Please try again!\n");
}
} while (!userName.equals(inputUserName));
do {
System.out.print("\nPassword : ");
inputPassWord = scanner.next();
if (!password.equals(inputPassWord)) {
System.out.println("Password is incorrect. Please try again!");
}
} while (!password.equals(inputPassWord));
clearConsole();
mainMenu(inputUserName, inputPassWord, supplier);
}
public static void mainMenu(String userName, String password, String[][] supplier ) {
Scanner input = new Scanner(System.in);
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| WELCOME TO IJSE STOCK MANAGEMENT SYSTEM |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("[1] Change the Credentils");
System.out.println("\t\t\t[2] Supplier Manage");
System.out.print("[3] Stock Manage");
System.out.println("\t\t\t\t[4] Log out");
System.out.println("[5] Exit the system\n");
System.out.print("Enter an option to continue > ");
int inputNum = input.nextInt();
//String [][] supplier = new String[0][2]; // null error
String[] category = new String[0]; // category array
String [][] item = new String [0][6]; // item array
clearConsole();
switch (inputNum) {
case 1 -> credentilManage(userName, password, supplier);
case 2 -> supplierManage(supplier , category , item);
case 3 -> stockManage(supplier, category , item);
case 4 -> loginPage(userName , password , supplier);
case 5 -> exitSystem();
default -> {
System.out.println("\n\nWrong number. please try again\n");
mainMenu(userName, password, supplier);
}
}
}
public static void credentilManage(String userName , String password , String[][] supplier)
{
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| CREDENTIAL MANAGE |");
System.out.println("+-----------------------------------------------------------------------------+\n");
Scanner scanner = new Scanner(System.in);
String verifyUserName;
String verifyPassword;
do {
System.out.print("Please enter the user name to verify it's you: : ");
verifyUserName = scanner.next();
if (!userName.equals(verifyUserName)) {
System.out.println("User name is invalid. Please try again!\n");
} else {
System.out.println("Hey " + verifyUserName+",");
}
} while (!userName.equals(verifyUserName));
do {
System.out.print("\nEnter yout current password : ");
verifyPassword = scanner.next();
if (!password.equals(verifyPassword)) {
System.out.println("Password is incorrect. Please try again!");
} else {
System.out.print("Enter your new password : ");
String newPassword = scanner.next();
System.out.print("\nPassword changed successfully! Do you want to go home page (y/n) ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
mainMenu(verifyUserName, newPassword, supplier);
} else {
clearConsole();
credentilManage(userName , password , supplier);
}
}
} while (!password.equals(verifyPassword));
}
public static void exitSystem() {
Scanner scanner = new Scanner(System.in);
System.out.print("Are you sure! you are leaving this program? [y/n] ");
char answer = scanner.next().charAt(0);
clearConsole();
if (answer == 'y' || answer == 'Y' ) {
System.out.println("\nbye byeee.......!");
System.exit(0);
} else {
System.out.println("\n\nYou can continue this programme.\n");
mainMenu(null, null, null);
}
}
public static String[][] supplierManage(String[][] supplier , String [] category , String [][]
item) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| SUPPLIER MANAGE |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print(" [1] Add supplier");
System.out.println("\t\t\t\t[2] Update supplier");
System.out.print(" [3] Delete supplier");
System.out.println("\t\t\t\t[4] View supplier");
System.out.print(" [5] Search supplier");
System.out.println("\t\t\t\t[6] Home page ");
Scanner scanner = new Scanner(System.in);
System.out.print("\nEnter an option to continue > ");
int inputNum = scanner.nextInt();
switch (inputNum) {
case 1 -> {
clearConsole();
addSupplier(supplier , category , item);
}
case 2 -> {
clearConsole();
updateSupplier(supplier , category , item);
}
case 3 -> {
clearConsole();
deleteSupplier(supplier , category , item);
}
case 4 -> {
clearConsole();
viewSupplier(supplier , category , item);
}
case 5 -> {
clearConsole();
searchSupplier(supplier , category , item);
}
case 6 -> {
clearConsole();
mainMenu(null, null, supplier);
}
default -> {
clearConsole();
System.out.println("\n\nWrong number. try again.\n");
supplierManage(supplier , category , item);
}
}
return supplier;
}
public static String[][] addSupplier(String[][] supplier , String [] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
boolean addNewsupplier = true;
while (addNewsupplier = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| ADD SUPPLIER |");
System.out.println("+-----------------------------------------------------------------------------+\n");
String[][] newSupplier = new String[supplier.length + 1][2];
for (int i = 0; i < supplier.length; i++) {
for (int j = 0; j < 2; j++) {
newSupplier[i][j] = supplier[i][j];
}
}
supplier = newSupplier;
System.out.print("\nEnter Supplier ID : ");
String supplierId = scanner.nextLine();
boolean checkId = false;
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null && supplier[i][0].equals(supplierId)) {
System.out.println("This supplier is already added.");
checkId = true;
break;
}
}
if (!checkId) {
System.out.print("Enter supplier name : ");
String supplierName = scanner.nextLine();
supplier[supplier.length - 1][0] = supplierId;
supplier[supplier.length - 1][1] = supplierName;
System.out.print("\nSupplier added successfully!");
System.out.print("Do you want to add another supplier [y/n]? ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'y' || answer == 'Y') {
addNewsupplier = true;
}
if (answer == 'n' || answer == 'N') {
addNewsupplier = false;
clearConsole();
supplierManage(newSupplier , category , item);
}
clearConsole();
}
}
return supplier;
}
public static void updateSupplier(String[][] supplier , String [] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
boolean updateSup = true;
while (updateSup = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| UPDATE SUPPLIER |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nInput Supplier ID : ");
String supplierId = scanner.nextLine();
boolean supplierFound = false;
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null && supplier[i][0].equals(supplierId)) {
supplierFound = true;
System.out.println("Supplier name : " + supplier[i][1]);
System.out.print("Supplier new name : ");
String newName = scanner.nextLine();
supplier[i][1] = newName;
System.out.print("Update successfully! Do you want to update another supplier?[y/n] ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'N') {
updateSup = false;
clearConsole();
supplierManage(supplier , category , item);
return;
} else {
updateSup = true;
clearConsole();
}
break;
}
}
if (!supplierFound) {
System.out.println("Supplier ID not found. Please try again.");
}
}
}
public static void deleteSupplier(String[][] supplier , String [] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
boolean deleteSup = true;
while (deleteSup = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| DELETE SUPPLIER |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nEnter supplier Id : ");
String supplierId = scanner.nextLine();
boolean checkId = false;
int index = -1;
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null && supplier[i][0].equals(supplierId)) {
checkId = true;
index = i;
break;
}
}
if (checkId) {
for (int i = index; i < supplier.length - 1; i++) {
supplier[i] = supplier[i + 1];
}
supplier[supplier.length - 1] = new String[2];
System.out.println("\nSupplier is deleted successfully!");
System.out.print("Do you want to delete another supplier [y/n] : ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'N' ) {
deleteSup = false;
clearConsole();
supplierManage(supplier , category , item);
return;
}
if (answer == 'y' || answer == 'Y'){
clearConsole();
}
} else {
System.out.println("Supplier ID is not found.");
}
}
}
public static void viewSupplier(String[][] supplier , String [] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
System.out.println("+-----------------------------------------------------------------------+");
System.out.println("| VIEW SUPPLIERS |");
System.out.println("+-----------------------------------------------------------------------+");
System.out.printf("\n\n+-----------------------+-----------------------+%n");
System.out.printf("| %-10s | %-10s |%n", "SUPPLIER ID",
"SUPPLIER NAME");
System.out.printf("+-----------------------+-----------------------+%n");
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null & supplier[i][1] != null ){
System.out.printf("| %-10s | %-10s |%n", supplier[i][0],
supplier[i][1]);
}
}
System.out.printf("+-----------------------+-----------------------+%n");
System.out.print("\n\nDo you want to go supplier manage page [y/n]? ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
addSupplier(supplier , category , item);
}
if (answer == 'n' || answer == 'N') {
clearConsole();
supplierManage(supplier , category , item);
}
}
public static void searchSupplier(String[][] supplier , String [] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
boolean searchSup = true;
while (searchSup = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| SEARCH SUPPLIER |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nInput Supplier ID : ");
String supplierId = scanner.nextLine();
boolean supplierFound = false;
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null && supplier[i][0].equals(supplierId)) {
supplierFound = true;
System.out.println("Supplier name : " + supplier[i][1]);
System.out.print("added successfully! Do you want to search another supplier?[y/n] ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'n') {
searchSup = false;
clearConsole();
supplierManage(supplier , category , item);
return;
}
if (answer == 'y' || answer == 'Y') {
searchSup = true;
clearConsole();
}
break;
}
}
if (!supplierFound) {
System.out.println("Supplier ID not found. Please try again.");
}
}
}
public static void stockManage(String[][] supplier, String[] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| STOCK MANAGEMENT |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print(" [1] Manage Item Categories");
System.out.println("\t\t\t [2] Add Item");
System.out.print(" [3] Get Items Supplier Wise");
System.out.println("\t\t\t [4] View Item");
System.out.print(" [5] Rank items per Unit Price");
System.out.println("\t\t\t [6] Home Page");
System.out.print("\nEnter an option to continue > ");
int inputNum = scanner.nextInt();
switch (inputNum) {
case 1 -> {
clearConsole();
category = manageItemCategories(supplier, category , item);
}
case 2 -> {
clearConsole();
item = addItem(supplier, category , item);
}
case 3 -> {
clearConsole();
getItemsSupplierWise(supplier , category , item);
}
case 4 -> {
clearConsole();
viewItem(supplier , category , item);
}
case 5 ->{
clearConsole();
rankItemsPerUnitPrice(supplier , category , item);
}
case 6 -> {
clearConsole();
mainMenu(null , null , supplier);
}
default -> {
clearConsole();
System.out.println("\n\nWrong number. try again.\n");
stockManage(supplier , category , item);
}
}
}
public static String[] manageItemCategories(String[][] supplier, String[] category , String [][]
item) {
Scanner scanner = new Scanner(System.in);
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| MANAGE ITEM CATEGORY |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print(" [1] Add New Item Category ");
System.out.println("\t\t\t [2] Delete Item Category");
System.out.print(" [3] Update Item Category");
System.out.println("\t\t\t [4] Stock Management");
System.out.print("\nEnter an option to continue > ");
int inputNum = scanner.nextInt();
switch (inputNum) {
case 1 -> {
clearConsole();
addNewItemCategory(supplier, category , item);
}
case 2 -> {
clearConsole();
deleteItemCategory(supplier, category , item);
}
case 3 -> {
clearConsole();
updateItemCategory(supplier, category , item );
}
case 4 -> {
clearConsole();
stockManage(supplier, category , item);
}
default -> {
clearConsole();
System.out.println("\n\nWrong number. try again.\n");
manageItemCategories(supplier, category , item);
}
}
return category;
}
public static String[] addNewItemCategory(String[][] supplier, String[] category , String [][]
item) {
Scanner scanner = new Scanner(System.in);
boolean addNewCategory = true;
while (addNewCategory = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| ADD ITEM CATEGORY |");
System.out.println("+-----------------------------------------------------------------------------+\n");
String[] newCategory = new String[category.length + 1];
for (int i = 0; i < category.length; i++) {
newCategory[i] = category[i];
}
System.out.print("\n\nInput Category name : ");
String categoryName = scanner.nextLine();
boolean checkId = false;
for (int i = 0; i < category.length; i++) {
if (category[i] != null && category[i].equals(categoryName)) {
System.out.println("This category is already added.");
checkId = true;
break;
}
}
if (!checkId) {
newCategory[category.length] = categoryName;
category = newCategory;
System.out.println("\nCategory added successfully!");
System.out.print("Do you want to add another category [y/n]? ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'N') {
addNewCategory = false;
clearConsole();
manageItemCategories(supplier, category , item);
// deleteItemCategory(supplier, newCategory , item );
// updateItemCategory(supplier, newCategory , item);
}
if (answer == 'y' || answer == 'Y') {
addNewCategory = true;
}
clearConsole();
}
}
return category;
}
public static void deleteItemCategory(String[][] supplier, String[] category , String [][] item) {
Scanner scanner = new Scanner(System.in);
boolean deleteCategory = true;
while (deleteCategory = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| DELETE ITEM CATEGORY |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nEnter category name: ");
String categoryName = scanner.nextLine();
boolean checkId = false;
int index = -1;
for (int i = 0; i < category.length; i++) {
if (category[i] != null && category[i].equals(categoryName)) {
checkId = true;
index = i;
break;
}
}
if (checkId) {
for (int i = index; i < category.length - 1; i++) {
category[i] = category[i + 1];
}
category[category.length - 1] = null;
System.out.println("\nSupplier is deleted successfully!");
System.out.print("\nDo you want to delete another supplier [y/n] : ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'N') {
deleteCategory = false;
clearConsole();
manageItemCategories(supplier , category , item);
return;
}
if (answer == 'y' || answer == 'Y') {
deleteCategory = true;
}
} else {
System.out.println("Supplier ID is not found.");
}
}
}
public static void updateItemCategory(String[][] supplier, String[] category , String [][] item)
{
Scanner scanner = new Scanner(System.in);
boolean updateCategory = false;
while (updateCategory = true) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| UPDATE ITEM CATEGORY |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nEnter category name : ");
String categoryName = scanner.nextLine();
boolean supplierFound = false;
for (int i = 0; i < category.length; i++) {
if (category[i].equals(categoryName)) {
supplierFound = true;
System.out.print("Category new name : ");
String newName = scanner.nextLine();
category[i] = newName;
System.out.print("Update successfully! Do you want to update another supplier?[y/n] ");
char answer = scanner.next().charAt(0);
scanner.nextLine();
if (answer == 'n' || answer == 'N') {
updateCategory = false;
clearConsole();
manageItemCategories(supplier, category , item);
deleteItemCategory(supplier, category , item);
return;
}
if (answer == 'y' || answer == 'Y') {
clearConsole();
updateCategory = true;
}
break;
}
}
if (!supplierFound) {
System.out.println("Category name not found. Please try again.");
}
// clearConsole();
}
}
public static String[][] addItem(String[][] supplier, String[] category, String[][] item) {
Scanner scanner = new Scanner(System.in);
boolean add = true;
while (add == true) {
System.out.println("\n+-----------------------------------------------------------------------------+");
System.out.println("| ADD ITEM |");
System.out.println("+-----------------------------------------------------------------------------+\n");
if (supplier.length == 0) {
System.out.println("OOPS! it seems that you don't have any supplier in the system");
System.out.print("Do you want to add a new supplier? [y/n] ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
supplier = addSupplier(supplier , category , item);
}
if (answer == 'n' || answer == 'N'){
clearConsole();
stockManage(supplier, category, item);
return item;
}
}
if (category.length == 0) {
System.out.println("OOPS! it seems that you don't have any item category in the system");
System.out.print("Do you want to add a new category? [y/n] ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
category = addNewItemCategory(supplier, category, item);
} else {
clearConsole();
stockManage(supplier, category, item);
return item;
}
}
String[][] newItem = new String[item.length + 1][6];
for (int i = 0; i < item.length; i++) {
for (int j = 0; j < item[i].length; j++) {
newItem[i][j] = item[i][j];
}
}
item = newItem;
System.out.print("\nEnter item code : ");
String itemCode = scanner.next();
boolean checkId = false;
for (int i = 0; i < item.length; i++) {
if (item[i][0] != null && item[i][0].equals(itemCode)) {
System.out.println("This item is already added.");
checkId = true;
break;
}
}
if (!checkId) {
System.out.println("\n\nSuppliers list:");
System.out.printf("+----------------+----------------------+-----------------------+%n");
System.out.printf("| %-8s | %-10s | %-10s |%n",
"#","SUPPLIER ID", "SUPPLIER NAME");
System.out.printf("+----------------+----------------------+-----------------------+%n");
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null & supplier[i][1] != null){
System.out.printf("| %-8s | %-10s |%-10s |%n",(i+1), supplier[i][0], supplier[i][1]);
}
}
System.out.printf("+----------------+----------------------+-----------------------+%n");
System.out.print("\nEnter the supplier number : ");
int supplierNumber = scanner.nextInt();
scanner.nextLine();
String supplierId = null;
if (supplierNumber > 0 && supplierNumber <= supplier.length) {
supplierId = supplier[supplierNumber - 1][0];
}
System.out.println("\n\nCategories list:");
System.out.printf("+----------------+-----------------------+%n");
System.out.printf("| %-8s | %-15s |%n" , "#" , "CATEGORYNAME");
System.out.printf("+----------------+-----------------------+%n");
for (int i = 0; i < category.length; i++) {
if (category[i] != null){
System.out.printf("| %-8s | %-15s |%n" ,
(i+1) , category[i]);
}
}
System.out.printf("+----------------+-----------------------+%n");
System.out.print("\n\nInput Item Category Number : ");
int categoryNumber = scanner.nextInt();
scanner.nextLine();
String categoryName = null;
if (categoryNumber > 0 && categoryNumber <= category.length) {
categoryName = category[categoryNumber - 1];
}
System.out.print("\n\nInput description: ");
String description = scanner.next();
System.out.print("\nInput unit price: ");
double unitPrice = scanner.nextDouble();
System.out.print("\nInput quantity on hand: ");
int qtyonHand = scanner.nextInt();
item[item.length - 1][0] = itemCode;
item[item.length - 1][1] = supplierId;
item[item.length - 1][2] = categoryName;
item[item.length - 1][3] = description;
item[item.length - 1][4] = String.valueOf(unitPrice);
item[item.length - 1][5] = String.valueOf(qtyonHand);
System.out.println("\nItem added successfully");
System.out.print("Do you want to add another Item [y/n]? ");
char anotherAnswer = scanner.next().charAt(0);
if (anotherAnswer == 'y' || anotherAnswer == 'Y') {
add = true;
}
if (anotherAnswer == 'n' || anotherAnswer == 'N'){
add = false;
clearConsole();
stockManage(supplier, category, item);
// getItemsSupplierWise(supplier, category, item);
}
clearConsole();
}
}
return item;
}
public static void getItemsSupplierWise(String[][] supplier, String[] category, String[][] item)
{
Scanner scanner = new Scanner(System.in);
boolean searchsup = true;
while (searchsup = true ) {
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| SEARCH SUPPLIER |");
System.out.println("+-----------------------------------------------------------------------------+\n");
System.out.print("\nEnter supplier id : ");
String supplierId = scanner.next();
boolean checkId = false;
for (int i = 0; i < supplier.length; i++) {
if (supplier[i][0] != null && supplier[i][0].equals(supplierId)) {
checkId = true;
System.out.print("Supplier name : " + supplier[i][1]+"\n\n");
System.out.printf("+------------+-----------------+------------+-------------+------------+%n");
System.out.printf("| %-10s | %-15s | %-10s | %-10s | %-10s |%n", "Item Code",
"Description", "Unit Price", "Qty On Hand", "Category");
System.out.printf("+------------+-----------------+------------+-------------+------------+%n");
for (int j = 0; j < item.length; j++) {
if (item[j][1] != null && item[j][1].equals(supplierId)) {
System.out.printf("| %-10s | %-15s | %-10s | %-10s | %-10s |%n",
item[j][0], item[j][3], item[j][4], item[j][5], item[j][2]);
}
}
System.out.printf("+------------+-----------------+------------+-------------+------------+%n");
}
}
if (!checkId) {
System.out.println("Supplier not found.");
}
System.out.print("\nDo you want to search for another supplier? [y/n] ");
char answer = scanner.next().charAt(0);
if (answer == 'n' || answer == 'N') {
searchsup = false;
clearConsole();
stockManage(supplier, category, item);
}
if (answer == 'y' || answer == 'Y') {
clearConsole();
searchsup = true;
}
}
clearConsole();
}
public static void viewItem (String [][] supplier , String [] category , String [][] item){
Scanner scanner = new Scanner(System.in);
if (item.length == 0) {
System.out.print("items not initialize. please add items.\n\n ");
clearConsole();
addItem(supplier, category, item);
}
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| VIEW ITEM |");
System.out.println("+-----------------------------------------------------------------------------+\n");
for (int i = 0; i < category.length; i++){
System.out.println("\nItem Category : " + category[i]);
System.out.printf("+-------------+------------+-------------+------------+-------------+%n");
System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |%n", "SupplierID", "Item Code", "Description", "Unit Price", "qty On Hand");
System.out.printf("+-------------+------------+-------------+------------+-------------+%n");
for (int j = 0; j < item.length; j++){
if (item[j][2] != null && item[j][2].equals(category[i])){
System.out.printf("| %-11s | %-10s | %-11s | %-10s | %-11s |%n",
item[j][1], item[j][0], item[j][3], item[j][4], item[j][5]);
}
}
System.out.printf("+-------------+------------+-------------+------------+-------------+%n");
}
System.out.print("\nDo you want to go stock manage page? [y/n] ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
stockManage(supplier, category, item);
}
if (answer == 'n' || answer == 'N') {
clearConsole();
mainMenu(null, null, supplier);
}
}
public static void rankItemsPerUnitPrice(String[][] supplier, String[] category, String[][] item)
{
Scanner scanner = new Scanner(System.in);
if (item.length == 0) {
System.out.print("items not initialize. please add items.\n\n ");
addItem(supplier, category, item);
}
System.out.println("+-----------------------------------------------------------------------------+");
System.out.println("| RANKED UNIT PRICE |");
System.out.println("+-----------------------------------------------------------------------------+\n");
double[] unitPrices = new double[item.length];
for (int i = 0; i < item.length; i++) {
unitPrices[i] = Double.parseDouble(item[i][4]); // Convert String to double
}
double[] sortedUnitPrices = arraySort(unitPrices);
System.out.printf("+--------------+------------+--------------+------------+--------------+------------+%n");
System.out.printf("| %-12s | %-10s | %-12s | %-10s | %-12s | %-10s |%n", "Supplier ID",
"Item Code", "Description", "Unit Price", "Qty On Hand", "Category");
System.out.printf("+--------------+------------+--------------+------------+--------------+------------+%n");
for (double unitPrice : sortedUnitPrices) {
for (String[] currentItem : item) {
if (Double.parseDouble(currentItem[4]) == unitPrice) { // Convert String to double
System.out.printf("| %-12s | %-10s | %-12s | %-10s | %-12s | %-10s |%n",
currentItem[1], currentItem[0], currentItem[3], currentItem[4], currentItem[5], currentItem[2]);
}
}
}
System.out.printf("+--------------+------------+--------------+------------+--------------+------------+%n");
System.out.print("\nDo you want to go stock manage page? [y/n] ");
char answer = scanner.next().charAt(0);
if (answer == 'y' || answer == 'Y') {
clearConsole();
stockManage(supplier, category, item);
}
if (answer == 'n' || answer == 'N') {
clearConsole();
mainMenu(null, null, supplier);
}
}
public static double[] arraySort(double[] newArray) {
for (int i = 0; i < newArray.length - 1; i++) {
for (int j = 0; j < newArray.length - 1 - i; j++) {
if (newArray[j] > newArray[j + 1]) {
double temp = newArray[j];
newArray[j] = newArray[j + 1];
newArray[j + 1] = temp;
}
}
}
return newArray;
}
}
