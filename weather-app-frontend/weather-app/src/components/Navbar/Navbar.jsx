import React, { useEffect, useState } from 'react'
import cities from '../../Countries-Cities/cities.json'
import getWeatherDetails from '../../service/FetchData'
import { toast } from 'react-toastify'
import './Navbar.css'

export const Navbar = () => {

    const [weatherData, setWeatherData] = useState(null)

    const [searchCity, setSearchCity] = useState('')

    const [selectedCity, setSelectedCity] = useState('bangalore')

    useEffect(() => {
        // console.log('city ->', selectedCity)

        if(selectedCity === null) {
            toast.error('Type proper city name.')
            return
        }
    
        getWeatherDetails(selectedCity).then(data => {
            
            // console.log('useEffect got data -> ', data)
            if(data.name === null) {
                // console.log('inside fetching -> ', data)
                toast.error('Type proper city name.')
                return
            }
            setWeatherData(data)
            toast.success(selectedCity+' weather details.!')
        }).catch(error => {
            // console.log('useEffect error ->', error)
            toast.error('Something went wrong!!')
        })
    },[selectedCity])

    const convertToDate = (data) => {
        return new Date(data * 1000).toLocaleString()
    }

    const handleSearchCity = (e) => {
        setSearchCity(e.target.value)
    }

    const handleSelectedCity = (event, selectedItem) => {
        // console.log('city name', event.target.value)
        event.preventDefault()
        let name = cities.filter((city) => city.name.toLowerCase().includes(selectedItem.toLowerCase()))
        
        if(name === null || name.length === 0) {
            // console.log('name is null -> ', name)
            toast.error('Enter proper city name.!!')
            return
        }

        // console.log('madchood ->',name[0].name)
        setSelectedCity(name[0].name)
        setSearchCity('')
    }

    // console.log('weather-data -> ', weatherData)

  return (
    <nav className='navbar'>
        <header>
            <div className='current-weather'>
                {
                    weatherData && 
                    <>
                        <div>Current Weather</div>
                        <span className='date-time'>
                            {convertToDate(weatherData.dt)}
                        </span>
                    </>
                }
            </div>
            <form>
                <div className='form-wrapper'>
                    <input type='text' placeholder='City Name'
                        name='searchCity' id='searchCity'
                        value={searchCity} onChange={handleSearchCity}
                    />
                    <button type='submit' onClick={(event) => handleSelectedCity(event, searchCity)}>CITY</button>
                </div>
            </form>
        </header>

        <main>
            <div className='weather-box'>
                {(weatherData) && (weatherData?.weather[0]) &&
                    <>
                    <img src={'https://openweathermap.org/img/wn/'+weatherData.weather[0].icon+'@2x.png'} alt="sun-moon"/>
                    <div className='degrees'>
                        <div className='deg-temp'>
                            <div className='temperature'>{weatherData.main.temp}</div>
                            <div className='deg-o'>o</div>
                        </div>
                        <div className='extra-requirements'>
                            <div className='city-name'>{weatherData.name}, {weatherData.sys.country}</div>
                            <div className='sun-rise-set'>
                                Sunrise {convertToDate(weatherData.sys.sunrise)} - Sunset {convertToDate(weatherData.sys.sunset)}
                            </div>
                        </div>
                    </div>
                    </>
                }
            </div>
            
            <div className='feels_like'>
                {
                    weatherData && weatherData?.weather[0] &&
                    <>
                        <div className='description'>{weatherData.weather[0].description}</div>
                        <div className='feels_like_deg'>
                            <div className='feels-like-main'>Feels like - {weatherData.main.feels_like}</div> 
                            <div className='feels-like-deg'>o</div>
                        </div>
                    </>
                }
            </div>
        </main>

        <section>
                <div className='grids'>
                {
                    weatherData && 
                    <>
                        <div className='box wind-speed'>
                            <span>Wind-Speed</span>
                            {weatherData.wind.speed} km/hr
                        </div>
                        <div className='box wind-deg'>
                            <span>Wind-Deg</span>
                            {weatherData.wind.deg} deg
                        </div>
                        <div className='box humidity'>
                            <span>Humidity</span>
                            {weatherData.main.humidity} %
                        </div>
                        <div className='box pressure'>
                            <span>Pressure</span>
                            {weatherData.main.pressure} mb
                        </div>
                        <div className='box visibility'>
                            <span>Visibility</span>
                            {weatherData.visibility} mtr 
                        </div>
                        <div className='box grnd-lvl'>
                            <span>Grnd-level</span>
                            {weatherData.main.grnd_level} mtr
                        </div>
                        <div className='box sea-lvl'>
                            <span>Sea-level</span>
                            {weatherData.main.sea_level} mtr
                        </div>
                    </>
                }
                </div>
        </section>
    </nav>
  )
}
