
const addButton = document.getElementById("addButton");

addButton.addEventListener("click", function () {
  const input1 = document.getElementById("number1").value.trim();
  const input2 = document.getElementById("number2").value.trim();
  const result = document.getElementById("result");

  if (input1 === "" || input2 === "") {
    result.textContent = "Result: Please enter valid numbers";
    return;
  }

  const a = Number(input1);
  const b = Number(input2);

  if (!Number.isFinite(a) || !Number.isFinite(b)) {
    result.textContent = "Result: Please enter valid numbers";
    return;
  }

  result.textContent = "Result: " + (a + b);
});
