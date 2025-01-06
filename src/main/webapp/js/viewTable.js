function showTable(tableId) {
    const tables = document.querySelectorAll('.table-container');
    tables.forEach(table => table.classList.add('hidden'));
    document.getElementById(tableId).classList.remove('hidden');
}