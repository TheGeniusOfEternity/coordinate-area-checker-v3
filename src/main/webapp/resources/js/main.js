(function (){
    const svgClickListener = function(e) {
        const svg = e.target.closest('svg#svg-graph');
        if (svg) {
            e.stopPropagation();
            console.log("SVG clicked!");
            handleSvgClick(e);
        }
    };
    window.cleanupBeforeNavigation = function() {
        for (let i = 1; i < 10000; i++) {
            clearInterval(i);
            clearTimeout(i);
        }
        document.removeEventListener("click", svgClickListener, false)
    };
    window.clearPrecision = () => {
        document.getElementById('main-form:precisedX').value = null;
        document.getElementById('main-form:precisedY').value = null;
    }
    function handleSvgClick(event) {
        const rInput = document.getElementById('main-form:rInput_input');
        if (!rInput || !rInput.value) {
            alert('Пожалуйста, выберите значение R');
            return;
        }

        const r = parseInt(rInput.value);
        const svg = document.getElementById('svg-graph');
        const rect = svg.getBoundingClientRect();

        const clickX = (event.clientX - rect.left) * (300 / rect.width);
        const clickY = (event.clientY - rect.top) * (300 / rect.height);

        const databaseX = ((clickX - 150) * r / 120).toFixed(2);
        const databaseY = ((150 - clickY) * r / 120).toFixed(2);

        const clampedX = Math.max(-r, Math.min(r, parseFloat(databaseX)));
        const clampedY = Math.max(-r, Math.min(r, parseFloat(databaseY)));

        console.log("Clicked: x=" + clampedX + ", y=" + clampedY);

        document.getElementById('main-form:precisedX').value = clampedX;
        document.getElementById('main-form:precisedY').value = clampedY;

        document.getElementById('main-form:add-point-btn').click();
    }

    document.addEventListener('click', svgClickListener, false);
    document.body.classList.remove("zoomed-out")
    document.body.classList.add("zoomed-in")
})();