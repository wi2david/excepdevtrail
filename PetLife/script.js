var elementsDoubt = document.querySelectorAll(".doubt")

elementsDoubt.forEach((doubt) => {doubt.addEventListener('click', () => {doubt.classList.toggle("active")})})