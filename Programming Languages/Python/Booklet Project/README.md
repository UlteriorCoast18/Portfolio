## 🚧 Pending Features / TODO

This project is currently **under active development**. The core PDF processing logic is already functional, but several important features are still missing or partially implemented.

Below is a list of planned improvements and pending tasks.

---

### 🖨️ Booklet Generation (Incomplete)
- The **“Prepare PDF to Booklet”** button is present in the UI but not fully implemented.
- The logic to:
  - Call the booklet preparation method
  - Track progress with a progress bar
  - Save the final booklet-ready PDF  
  is still pending.

---

### ✂️ Cropping Logic Integration
- The user can visually draw a cropping rectangle on the canvas.
- However:
  - The selected crop area is **not yet applied** to the PDF processing logic.
  - The rectangle coordinates are currently visual-only.
- Next steps:
  - Convert canvas coordinates to PDF coordinates.
  - Apply cropping using PyPDF2 transformations.

---

### 📄 Resize PDF Feature
- The **“Resize PDF”** button exists but has no functionality yet.
- Planned features:
  - Resize entire PDF to a selected paper size (A1–A6).
  - Use the selected value from the size combobox.
  - Optional progress bar integration.

---

### 📊 Unified Progress Tracking
- Progress bars are currently implemented only for specific operations.
- Missing improvements:
  - Unified progress reporting across all heavy PDF operations.
  - Consistent percentage scaling when multiple steps are involved.
  - Better distinction between “processing”, “converting”, and “finalizing”.

---

### 🧹 Error Handling & Validation
- Currently missing:
  - Validation for invalid or corrupted PDF files.
  - User feedback if a process fails.
  - Graceful handling of missing folders (`aux`, `input`, `output`).

---

### 🧠 Code Organization Improvements
- Some logic could be refactored for better structure:
  - Separate UI logic from PDF processing more cleanly.
  - Reduce use of global variables.
  - Improve naming consistency and documentation.

---

### 📝 Documentation
- Missing documentation includes:
  - Installation instructions
  - Required dependencies
  - Folder structure explanation
  - Usage examples

---

### ✨ Optional Future Improvements
- Multi-page preview navigation.
- Zoom controls for PDF preview.
- Keyboard shortcuts.
- Cross-platform packaging (e.g. executable).
- Dark mode / UI theming.

---

## ⚠️ Project Status

This project is **functional but incomplete**.  
It is intended as a learning and portfolio project focused on:
- PDF manipulation
- GUI development with Tkinter
- Multithreading and progress reporting
- File handling and document layout logic

Contributions and refactoring are welcome.
