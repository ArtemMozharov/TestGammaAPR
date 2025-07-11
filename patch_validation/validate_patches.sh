#!/bin/bash

# Define paths
PROJECT_DIR="/home/artemmozharov/Documents/Studium/Sem4/ML4SWE Seminar/ML4SWE/ExampleProjext"
PATCHES_FILE="$PROJECT_DIR/patch_validation/patches.txt"
ORIGINAL_FILE="$PROJECT_DIR/src/main/java/StockSeller.java"
TEMP_FILE="$PROJECT_DIR/src/main/java/StockSeller.java.tmp"
REPORT_FILE="$PROJECT_DIR/patch_validation/report.csv"

# Backup the original file
cp "$ORIGINAL_FILE" "$ORIGINAL_FILE.bak"

# Create CSV header
echo "Patch,Compiles,TestsPass" > "$REPORT_FILE"

# Loop through patches
while IFS= read -r patch; do
    # Restore original file for a clean slate
    cp "$ORIGINAL_FILE.bak" "$ORIGINAL_FILE"

    # Apply patch
    sed "20s#.*#$patch#" "$ORIGINAL_FILE" > "$TEMP_FILE" && mv "$TEMP_FILE" "$ORIGINAL_FILE"

    # Compile
    if mvn -f "$PROJECT_DIR/pom.xml" compile &> /dev/null; then
        compiles="true"
        # Run tests
        if mvn -f "$PROJECT_DIR/pom.xml" test &> /dev/null; then
            tests_pass="true"
        else
            tests_pass="false"
        fi
    else
        compiles="false"
        tests_pass="false"
    fi

    # Write to report
    echo ""$patch",$compiles,$tests_pass" >> "$REPORT_FILE"

done < "$PATCHES_FILE"

# Restore the original file
mv "$ORIGINAL_FILE.bak" "$ORIGINAL_FILE"

echo "Validation complete. Report generated at $REPORT_FILE"
