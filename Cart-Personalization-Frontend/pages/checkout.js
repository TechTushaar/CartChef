import React from 'react'
import {
  Container,
  Typography,
  Button,
  Card,
  CardActions,
  CardMedia,
  CardContent,
  Modal,
  Checkbox,
  Box,
  FormGroup,
  FormControlLabel,
  FormControl,
  FormLabel,
} from '@material-ui/core'
import { makeStyles } from '@material-ui/core/styles'
import axios from 'axios'
const label = { inputProps: { 'aria-label': 'Checkbox demo' } }
const recipe1 = ["Chicken Congee", "https://www.themealdb.com/images/media/meals/1529446352.jpg"]
const missingItems1 = ["Great Value pepper", "Whole Foods spring onions", "Great Value salt", "Trader Joe's coriander", "Trader Joe's ginger cordial",
"Trader Joe's water"]


const items = ['chicken', 'ginger', 'garlic']

const useStyles = makeStyles(theme => ({
  main: {
    display: 'flex',
    alignItems: 'center',
    flexDirection: 'column',
    textAlign: 'center',
    margin: theme.spacing(10, 0, 0, 0),
  },
}))

var data1 = JSON.stringify({
  "shoppingCart": [
    "chicken",
    "rice",
    "ginger"
  ]
});

var data2 = JSON.stringify({
  "shoppingCart": [
    "chicken",
  ]
});

var config = {
  method: 'put',
  url: 'https://ncr-hackathon-cart-recipe.uc.r.appspot.com/v1/getItems',
  headers: {
    'Content-Type': 'application/json'
  },
  data : data1
};

var config2 = {
  method: 'put',
  url: 'c',
  headers: {
    'Content-Type': 'application/json'
  },
  data : data2
};


const getData = () => {
axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});
}

const getData2 = () => {
  axios(config2)
  .then(function (response) {
    response = response.json();
  })
  .then((resJson) => {
    const data = JSON.parse(resJson)
    console.log(data);
  });
  // axios.put('https://ncr-hackathon-cart-recipe.uc.r.appspot.com/v1/getItems', { "shoppingCart": ['chicken'] }).then((res) => {
  //   console.log(res);
  // }).catch(err => {
  //   alert(err)
  //   console.log(err)
  // })
}
const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
}

export default function Checkout() {
  const classes = useStyles()
  const names = ['Chicken Stock', 'Chicken and Mushroom Hotpot', 'Chicken Alfredo Primavera']

  const handleChange = e => {
    const [name, setName] = useState('')
    const [value, setValue] = useState('')
  }
  const [open, setOpen] = React.useState(false)
  const handleOpen = () => setOpen(true)
  const handleClose = () => setOpen(false)

  return (
    <div className={classes.main}>
      <Typography>Recipes based on shopping cart</Typography>
      <Button onClick={getData}>Hi</Button>
      <Card sx={{ maxWidth: 100, position: 'center' }}>
        <CardMedia
          component="img"
          height="fit"
          image={recipe1[1]}
          alt="Image not available"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            Chicken Congee
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="medium" color="error" onClick={handleOpen}>
            Add Missing Items
          </Button>
          <Modal
            keepMounted
            open={open}
            onClose={handleClose}
            aria-labelledby="keep-mounted-modal-title"
            aria-describedby="keep-mounted-modal-description"
          >
            <Box sx={style}>
              <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
                Choose missing items for your recipe
              </Typography>
                <FormControl component="fieldset">
                  <FormGroup aria-label="position" row>
                    <FormControlLabel
                      value="Garlic"
                      control={<Checkbox />}
                      label="Garlic"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Mushroom"
                      control={<Checkbox />}
                      label="Mushroom"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Ginger"
                      control={<Checkbox />}
                      label="Ginger"
                      labelPlacement="start"
                    />
                  </FormGroup>
                </FormControl>
            </Box>
          </Modal>
        </CardActions>
      </Card>



      <Card sx={{ maxWidth: 100, position: 'center' }}>
        <CardMedia
          component="img"
          height="fit"
          image="https://www.themealdb.com/images/media/meals/uuuspp1511297945.jpg"
          alt="Image not available"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {names[1]}
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="medium" color="error" onClick={handleOpen}>
            Add Missing Items
          </Button>
          <Modal
            keepMounted
            open={open}
            onClose={handleClose}
            aria-labelledby="keep-mounted-modal-title"
            aria-describedby="keep-mounted-modal-description"
          >
            <Box sx={style}>
              <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
                Choose missing items for your recipe
              </Typography>
                <FormControl component="fieldset">
                  <FormGroup aria-label="position" row>
                    <FormControlLabel
                      value="Garlic"
                      control={<Checkbox />}
                      label="Garlic"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Mushroom"
                      control={<Checkbox />}
                      label="Mushroom"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Ginger"
                      control={<Checkbox />}
                      label="Ginger"
                      labelPlacement="start"
                    />
                  </FormGroup>
                </FormControl>
            </Box>
          </Modal>
        </CardActions>
      </Card>


      <Card sx={{ maxWidth: 100, position: 'center' }}>
        <CardMedia
          component="img"
          height="fit"
          image="https://www.themealdb.com/images/media/meals/syqypv1486981727.jpg"
          alt="Image not available"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {names[2]}
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="medium" color="error" onClick={handleOpen}>
            Add Missing Items
          </Button>
          <Modal
            keepMounted
            open={open}
            onClose={handleClose}
            aria-labelledby="keep-mounted-modal-title"
            aria-describedby="keep-mounted-modal-description"
          >
            <Box sx={style}>
              <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
                Choose missing items for your recipe
              </Typography>
                <FormControl component="fieldset">
                  <FormGroup aria-label="position" row>
                    <FormControlLabel
                      value="Garlic"
                      control={<Checkbox />}
                      label="Garlic"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Mushroom"
                      control={<Checkbox />}
                      label="Mushroom"
                      labelPlacement="start"
                    />
                    <FormControlLabel
                      value="Ginger"
                      control={<Checkbox />}
                      label="Ginger"
                      labelPlacement="start"
                    />
                  </FormGroup>
                </FormControl>
            </Box>
          </Modal>
        </CardActions>
      </Card>


    </div>
  )
}
