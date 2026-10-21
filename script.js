const addButton = document.getElementById("addButton");

addButton.addEventListener("click", function () {
  const a = Number(document.getElementById("number1").value);
  const b = Number(document.getElementById("number2").value);
  document.getElementById("result").textContent = "Result: " + (a + b);
});