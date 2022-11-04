function colors(){
    let red = parseInt(Math.random()*255);
    let green = parseInt(Math.random()*255);
    let blue = parseInt(Math.random()*255);
    return `rgb(${red},${green},${blue})`
}

function banhChart(id, banhLabels=[], banhInfo=[])
{
    let color = []
    for(let i = 0; i < banhInfo.length; i++)
        color.push(colors())
    
    const data = {
        labels: banhLabels,
        datasets: [{
            label: 'Thong ke',
            data: banhInfo,
            backgroundColor: color,
            borderColor: color,
            hoverOffset: 4
        }]
    };
    
    const config = {
        type: 'bar',
        data: data,
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
}

